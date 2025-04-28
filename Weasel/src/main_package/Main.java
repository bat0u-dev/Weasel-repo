package main_package;
/*
 * -Данная программа должна реализовать пример формирования нужного нам предложения, в результате алгоритма имитации
 * искусственного накопительного отбора. Каждую отборочную итерацию, вследствие которой промежуточная
 * структура изменяется случайным образом (в рамках заданных условий), программа сохраняет "полезные"
 * свойства промежуточной результирующей структуры. "Полезными" считаются те свойства промежуточной результирующей
 * структуры, в которых она идентична целевой (в данном случае заранее известной) структуре. Т.е., если совпало место и
 * значение символа в предложении, то такой символ в нем является его полезнвым свойством.
 * *********************************************************************************************************************
 * Далее возможный вариант реализации программы:
 * 1) Создать массив символов, содержащий латинский алфавит и пробел.
 * 2) Из элементов массива выбранных в случайном порядке формировать предложение содержащее количество символов,
 * равное количеству символов в целевом предложении (?пользователь вводит с клавиатуры).
 * 3) Каждую итерацию формирования "рандомного" предложения посимвольно сравнивать его с целевым, и сохранять положение
 * символа там, где оно совпадает с положением соответствующего символа в целевом предложении (для фиксации "полезных"
 * изменений создается третий массив символов, впоследствии из него создается финальная строка).
 * 4) Повторять процедуру отбора и сравнения, пока программа не сформирует предложение полностью идентичное целевому.
 * 5)END.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char[] Symbols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};//*hardcode! 27 symbols
    private static final Scanner scr = new Scanner(System.in);
    private static String finalSentence;//= "methinks it is like a weasel";
    private static char[] fSChar;
    private static char[] intSChar;
    private static char[] resultChar;
    private static Random random = new Random();

    public static void main(String[] args) throws Exception{
        System.out.print("Введите целевое предложение: ");
       finalSentence = scr.nextLine();
       fSChar = finalSentence.toCharArray();
       resultChar = new char[finalSentence.length()];
        int counter=0;
        do{
         intSChar = createSentence();
         counter++;
         for(int i = 0; i< fSChar.length; i++){

             if(fSChar[i]== intSChar[i]){
                 resultChar[i]= fSChar[i];
             }
         }

            System.out.println(intSChar);
            System.out.println(charArrToStr(resultChar) + "\n");
            Thread.sleep(1200);
        }while (!(Arrays.toString(fSChar).equals(Arrays.toString(resultChar))));
        System.out.println("Потребовалось " + counter + " шагов.");
    }

        private static int[] getNumAlphabet( char[] alphabet){

            int[] tempCharArr = new int[alphabet.length];
            for (int i = 0; i < alphabet.length; i++) {
                int c = Character.getNumericValue(alphabet[i]);
                tempCharArr[i] = c;
            }
            return tempCharArr;
        }

        private static int getRandomElement (){
            int rnd =  random.nextInt(Main.Symbols.length);
            return Main.Symbols[rnd];
        }


        private static char[] createSentence () {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < finalSentence.length(); i++) {
                builder.append((char) getRandomElement());
            }
            return builder.toString().toCharArray();
        }

        private static StringBuilder charArrToStr(char[] inputCharArr){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< finalSentence.length(); i++){
            if(resultChar[i]=='\u0000')builder.append('-');
            else{builder.append(resultChar[i]);}
        }
        return builder;
        }

    }

