package main_package;
/*
 * -Данная программа должна реализовать пример генезиса нужной нам "сложной" структуры в результате алгоритма имитации
 * искусственного накопительного отбора, при котором каждую отборочную итерацию, в следствие которой промежуточная
 * структура изменяется случайным образом (в рамках заданных условий), программа сохраняет "полезные"
 * свойства промежуточной результирующей структуры. "Полезными" считаются те свойства промежуточной результирующей
 * структуры, в которых она идентична целевой (в данном случае заранее известной) структуре.
 * *********************************************************************************************************************
 * Далее возможный вариант реализации программы:
 * 1) Создать массив символов, содержащий латинский алфавит и пробел.
 * 2) Из элементов массива выбранных в случайном порядке формировать предложение содержащее количество символов,
 * равное количеству символов в целевом предложении (?пользователь вводит с клавиатуры).
 * 3) Каждую итерацию формирования "рандомного" предложения посимольно сравниват его с целевым, и сохранять положение
 * символа там, где оно совпадает с положением соответствующего символа в целевом предложении (для фиксации "полезных"
 * изменений создается третий массив символов, в последствии из него создается финальная строка).
 * 4) Поворять процедуру отбора и сравнения, пока программа не сформирует предложение полностю идентичное целевому.
 * 5)END.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char[] Symbols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};//*hardcode! 27 symbols
    private static Scanner scr = new Scanner(System.in);
    private static String FinalSentence;//= "methinks it is like a weasel";
    private static char[] FSChar;
    private static char[] IntSChar;
    private static char[] ResultChar;
    private static String ResultCharArrToString;

    public static void main(String[] args) throws Exception{
       FinalSentence = scr.nextLine();
       FSChar = FinalSentence.toCharArray();
       ResultChar = new char[FinalSentence.toCharArray().length];
        int counter=0;
        do{
         IntSChar = createSentence();
         for(int i=0; i<FSChar.length;i++){
             counter++;
             if(FSChar[i]==IntSChar[i]){
                 ResultChar[i]=FSChar[i];
             }
         }

            System.out.println(IntSChar);
            System.out.println(charArrToStr(ResultChar) + "\n");
            Thread.sleep(1200);
        }while (!(Arrays.toString(FSChar).equals(Arrays.toString(ResultChar))));
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

        private static int getRandomElement ( char[] elementArr){
            int rnd = new Random().nextInt(elementArr.length);
            return elementArr[rnd];
        }


        private static char[] createSentence () {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < FinalSentence.length(); i++) {
                builder.append((char) getRandomElement(Symbols));
            }
            return builder.toString().toCharArray();
        }

        private static StringBuilder charArrToStr(char[] inputCharArr){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<FinalSentence.length();i++){
            if(ResultChar[i]=='\u0000')builder.append('-');
            else{builder.append(ResultChar[i]);}
        }
        return builder;
        }

    }

