$(function () {

    const appendTask = function (data) {
        var taskCode = '<tr>' +
                            '<th data-id="' + data.id + '">' + data.id +'</th>' +
                            '<td>' + data.taskName +'</td>' +
                            '<td><input class="form-check-input" type="checkbox" value="' + data.done + '"></td>' +
                            '<td><button class="btn btn-primary" data-id="' + data.id + '">ред.</button></td>' +
                            '<td><button class="btn btn-danger" data-id="' + data.id + '">удалить</button></td>' +
                        '</tr>';

        $('#task-list').append(taskCode);
    }

    //get all tasks
    $.get('/tasks/', function (response) {
        for (i in response) {
            appendTask(response[i]);
        }
    })
})