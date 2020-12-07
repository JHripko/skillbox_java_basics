public class Main {

    public static void main(String[] args) {
        String text = "On 7 September 1940, southern England suffered what was then the biggest air raid the world had ever seen. Over the previous three months, the aircraft of Germany’s Luftwaffe had tried to break the resistance of Britain’s Royal Air Force (RAF). Already severely depleted from the heavy fighting during the invasion of France, the RAF had buckled several times under the strain. A particularly brutal offensive against its airfields and the factories producing its fighter planes over the weeks before had left it dangerously close to running out of both planes and pilots. If the attacks had carried on with the same intensity for a few more weeks, the RAF might have collapsed completely. German invasion barges were waiting on the other side of the channel for just such a moment. But then Germans then turned their attention – mystifyingly – to Britain’s cities, hoping that indiscriminate bombing would cause widespread panic and force Britain to surrender. The Luftwaffe decided to throw every available aircraft into the offensive. It started on 7 September. During the early afternoon, British radar observers hunched over their screens started seeing something massive taking shape. From airfields across France, wave after wave of German bombers and fighters took to the air, forming up into one enormous formation over the English Channel. It was so large – nearly 1,100 planes – that it covered 800 square miles. The last time a force this powerful had threatened England was the Spanish Armada, 500 years before.";

        System.out.println(splitTextInToWords(text));
    }

    public static String splitTextInToWords(String text) {

        String myText = text
                .replaceAll("[;\\-,.\\s0-9]+", "\n")
                .trim();
        return myText;
    }
}