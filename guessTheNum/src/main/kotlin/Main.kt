import java.util.Scanner
import kotlin.random.Random

fun setMax() :Int{

    print("Choose the maximum number for your guess: ")
    var input :Int = -1

    while (input == -1){
        try {
            input = Scanner(System.`in`).nextInt()
        }catch (e :Exception){
            println("Must be an int")
        }
    }

    while (input <= 1){
        println("Max num cannot be below 1")
        print("Choose the maximum number for your guess: ")
        input = Scanner(System.`in`).nextInt()
    }
    return input
}

fun numGen(max :Int) :Int{

    return Random.nextInt(0, max + 1)
}

fun playerInput() :Int{

    while (true){

        try {

            return Scanner(System.`in`).nextInt()
        }catch (e :Exception){
            println("Must be an int")

        }
    }
}

fun setMaxGuess() :Int?{

    var maxGuess :Int?

    print("Limit the number of guesses :")
    try {

        maxGuess = Scanner(System.`in`).nextInt()
        return maxGuess
    }catch (e :Exception){

        maxGuess = null
        return maxGuess
    }
}

fun main() {

    var inGame :Boolean = true
    val max :Int = setMax()
    var guesses :Int = 0
    val maxGuess :Int? =setMaxGuess()
    val num :Int = numGen(max)

    print("Guess the num between 1 and $max: ")

    while (inGame){

        print("Guess the num between 0 and $max: ")
        var guess :Int = playerInput()
        if (guess == max){
            println("you won your num was $num and you guessed it right with $guesses guess")
        }

        if (maxGuess == null){
            guesses++
        }else{
            if (guesses == maxGuess -1){
                println("Vesztettél")
                inGame = false
            }else{
                guesses++
            }
        }
    }


}
