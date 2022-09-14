var tasksApi = Vue.resource('/tasks/{id}');

//получение объекта массива по id
function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }

        return -1;
    }
}

//форма ввода названия задачи
Vue.component('task-form', {
    props: ['tasks', 'taskAttr'],
    data: function () {
        return {
            text: '',
            id: ''
        }
    },
    watch: {
        //замена текста в поле input при редактировании имени задачи
        taskAttr: function(newTask, oldTask) {
            this.text = newTask.taskName;
            this.id = newTask.id;
        }
    },
    template:
        '<div class="row">' +
            '<div class="col">' +
                '<form class="input-group mb-3 text-center">' +
                    '<input type="text" class="form-control-sm" placeholder="Новая задача" v-model="text">' +
                    '<button class="btn btn-success" type="button" @click="save">Добавить</button>' +
                '</form>' +
            '</div>' +
            '<div class="col">' +
                '<button class="btn btn-danger" id="delete-all" type="button" @click="deleteAll">Удалить все</button>' +
            '</div>'+
        '</div>',
    methods: {
        //сохранение задачи
        save: function () {
            var task = {id: this.id, taskName: this.text, done: false};
            //параметры запросов для добавления и редактирования задачи
            var customActions = {
                add: {method: 'POST', url: '/tasks/?taskName=' + task.taskName},
                edit: {method: 'PUT', url: '/tasks/?id=' + task.id + '&taskName=' + task.taskName}
            }

            //шаблон запроса
            var resource = this.$resource('/tasks/', {}, customActions);

            //если поле id не пустое, то считаем что мы редактируем существующую задачу а не добавляем новую
            if (task.id !== '') {
                resource.edit().then(response => {
                    response.json().then(data => {
                        var index = getIndex(this.tasks, data.id);
                        this.tasks.splice(index, 1, data);
                    })
                })
                //очищаем поле ввода названия задачи и id
                this.text = '';
                this.id = '';
            } else {
                //иначе - считаем что добавляем новую задачу
                resource.add().then(response => {
                    response.json().then(data => {
                        task.id = data;
                        this.tasks.push(task);
                        this.text = '';
                    })
                })
            }
        },
        //удалить все задачи
        deleteAll: function () {
            tasksApi.remove().then(result => {
                if (result.ok) {
                    this.tasks.splice(0, this.tasks.length);
                }
            })
        }
    }
});

//строка таблицы списка задач [id задачи, название задачи, чекбокс со статусом выполнена/не
// выполнена, кнопка редактировать, кнопка удалить]
Vue.component('task-row', {
    props: ['task', 'editMethod', 'tasks'],
    template:
        '<tr>' +
            '<td>{{task.id}}</td>' +
            '<td>{{task.taskName}}</td>' +
            '<td><input class="form-check-input" type="checkbox" :value="task.id" :checked="task.done" @click="done" /></td>' +
            '<td><button class="btn btn-sm btn-primary" type="button" @click="edit">ред.</button></td>' +
            '<td><button class="btn btn-sm btn-danger" type="button" @click="del">удалить</button></td>' +
        '</tr>',
    methods: {
        //при нажатии кнопки редактировать, передаем в метод текущую задачу в строке
        edit: function () {
            this.editMethod(this.task);
        },
        //при нажатии кнопки удалить, создаем запрос на удаление файла по id
        del: function () {
            tasksApi.remove({id: this.task.id}).then(result => {
                //если сервер возвращает результат о выполнении, то удаляем задачу из списка
                if (result.ok) {
                    this.tasks.splice(this.tasks.indexOf(this.task), 1)
                }
            })
        },
        //при нажатии на чекбокс, изменяем статус задачи на противоположный
        done: function () {
            tasksApi.update({id: this.task.id}, {}).then(response => {
                if (response.ok) {
                    response.json(data => {
                        this.tasks.splice(this.task.id, 1, data);
                    })
                }
            })
        }
    }
});

//таблица списка задач
Vue.component('tasks-list', {
    props: ['tasks'],
    data: function (){
        return {
            task: null
        }
    },
    template:
        '<div>' +
            '<task-form :tasks="tasks" :taskAttr="task"/>' +
            '<table class="table table-striped">' +
                '<thead>' +
                    '<th>#</th>' +
                    '<th>Задача</th>' +
                    '<th>Выполнено</th>' +
                    '<th></th>' +
                    '<th></th>' +
                '</thead>' +
                '<tbody>' +
                    '<task-row v-for="task in tasks" :key="task.id" :task="task" :editMethod="editMethod" :tasks="tasks"/>' +
                '</tbody>' +
            '</table>' +
        '</div>',
    //хук жизненного цикла - как только компонент будет создан, произойдет запрос на сервер для получения списка задач
    created: function () {
        tasksApi.get().then(result => {
            result.json().then(data => {
                data.forEach(task => this.tasks.push(task));
            })
        });
    },
    methods: {
        editMethod: function (task){
            this.task = task;
        }
    }
});

var app = new Vue({
    el: '#app',
    template:
        '<tasks-list :tasks="tasks" />',
    data: {
        tasks: []
    }
});