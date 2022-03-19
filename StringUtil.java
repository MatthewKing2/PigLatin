import java.util.Locale;

public class StringUtil{


    //Create a method that receives a String and returns ist reversal.
    public static String reverse(String phrase) {
        String reversed = "";
        int length = phrase.length();
        int x = 1;
        //Incroments through phrase backwards and adds the letter to reversed.
        while (length-x >= 0){
            reversed += phrase.substring(length-x,length-x+1);
            x++;
        }
        return reversed;
    }


    //Create a method that determins if a String is a Palindrome.
    public static boolean palindrome(String phrase){

        String reworkedPhrase = phrase.replaceAll("[^A-Za-z]", "").toLowerCase();   //Gets rid of anything that isnt a letter.
        int y = reworkedPhrase.length();//Indexs from the last letter to the first.
        int x = 0;                      //Indexs from the first letter to the last.
        int matchingLetters = 0;        //Counts the number of matching letters between x & y.
        while (y > 0){

            if (reworkedPhrase.substring(x,x+1).equals(reworkedPhrase.substring(y-1,y))){matchingLetters++;} //Sees if x's letter = y's letter.
            x++;
            y--;
            if (matchingLetters == reworkedPhrase.length()){return true;} //If the number of matching letters is the same as the length of the word, then its a palidrome.
            else if(y == 0){return false;}

        }
        return false; //Need this here because java, tbh idk why :|
    }


    //Create a method to return the piglatinated version of a sentence.
    public static String piglatinator(String bigPhrase){

        String[] arr = bigPhrase.split(" ");      //Breaks the input string (bigPhrase) into an array (with each value in the array being a word in BigPhrase)
        String pigLatinatedwords = "";                  //Final Return - This will be the string with all the piglatinated words

        //Runs for every word in bigPhrase
        for (String phrase: arr){
            //Resets the indexFirstVowel to -1 for each word
            int indexFirstVowel = -1; //Start with -1, because that is an invalid index of a string in java

            //Finds out if the word has vowels (and their index(s))
            for (int i = 0; i < phrase.length(); i ++){

                //Finds the index of the first vowel if there is one.
                if(phrase.substring(i,i+1).matches("a||A||e||E||i||I||o||O||u||U")) {
                    indexFirstVowel = i;
                    break;  /*breaks out of the for loop. If you did not break out, the indexFirstVowel would get set to the index of the last vowel in the word.*/ }
            }

            //What to do with words depending on vowel count/location (adds final product to the finnal list)
            if (indexFirstVowel == 0){pigLatinatedwords += " " + (phrase += "yay");}  //If first letter is a Vowel, add "yay" to the end
            else if (indexFirstVowel == -1){pigLatinatedwords += " " + (phrase += "ay");}  //If there are no vowels, add "ay" to the end
            else if (indexFirstVowel > 0 && phrase.substring(0,1).matches("[A-Z]")){pigLatinatedwords += " " + (phrase.substring(indexFirstVowel).toUpperCase().charAt(0)/*Cap. first lett of End*/ + phrase.substring(indexFirstVowel+1)/*End without first letter*/ + phrase.substring(0,indexFirstVowel).toLowerCase()/*Start*/ + "ay");} //If the first letter is capitalized: End + start + "ay", as specified in the google doc.
            else if (indexFirstVowel > 0){pigLatinatedwords += " " + (phrase.substring(indexFirstVowel) + phrase.substring(0,indexFirstVowel) + "ay");}   //If there is a vowel but doesn't start with a vowel, then: end + start + "ay", as specified in the google doc.
            else{System.out.println("There is no else, you messed it up dumbie");}

        }
        return pigLatinatedwords; //Finnal list
    }


    //Create a method to return the shorthand version of a sentence.
    public static String shorthand(String bigPhrase){

        String[] arr = bigPhrase.split(" ");      //Breaks the input string (bigPhrase) into an array (with each value in the array being a word in BigPhrase)
        String shorthand = "";                          //Final Return - This will be the string with all the shorthand abbreviations

        for (String phrase: arr){

            int isVowel = 0; //0 is False, 1 is True (didnt use boolean cause I hate them :)

            //Finds out if the word has any vowels
            for (int i = 0; i < phrase.length(); i ++){
                if(phrase.substring(i,i+1).matches("a||A||e||E||i||I||o||O||u||U")){ //If phrase had vowls:
                    isVowel = 1;/*Sets isVowl to true(1)*/}
            }

            // Convers the phrase to the correct abreivation.
            if(phrase.equals("and")){shorthand += " &";}
            else if(phrase.equals("to")){shorthand += " 2";}
            else if(phrase.equals("you")){shorthand += " U";}
            else if(phrase.equals("for")){shorthand += " 4";}
            else if(isVowel == 1){shorthand += (" " + phrase.replaceAll("[aeiouAEIOU]" , ""));} //Gets rid of all vowels (UPPER & lower)

        }
        return shorthand;
    }


}