package anagramkt
import java.io.File
import java.io.InputStream

class Anagram {

    private val anagrams: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
    
   constructor(words: List<String>) {
       retrieveAnagrams(words);
   }

   constructor(fileName: String) {
    val inputStream: InputStream = File(fileName).inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    //println(inputString)
    val words: List<String> = inputString.split("\n");
    //println(words[0])
    retrieveAnagrams(words);
   }

   private fun retrieveAnagrams(words: List<String>){
    for(i in 0..words.size-1){
        var word_sorted: String = words[i].split("").sorted().joinToString("")
        var setOfAnagrams: MutableList<String>? = anagrams[word_sorted];
        if(setOfAnagrams != null){
             setOfAnagrams.add(words[i])
        }
        else{
            anagrams.set(word_sorted, mutableListOf<String>(words[i]))
        }
    }
   }


   fun print() {
        anagrams.forEach{ _, v ->
            if(v.size > 1){
                println(v.joinToString())
            }
        }  
   }

   fun alternatePrint(){
       var result = ""
    anagrams.forEach{ _, v ->
        if(v.size > 1){
            result+=v.joinToString()+"\n"
        }
    }
    println(result)
   }

   
}
