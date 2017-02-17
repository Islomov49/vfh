package com.eng.iso.sharipova.Utils;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseAdvantagesDisadvantegs;
import com.eng.iso.sharipova.Entity.ExerciseAnswerQuestions;
import com.eng.iso.sharipova.Entity.ExerciseComWordsFillWrite;
import com.eng.iso.sharipova.Entity.ExerciseFillTextWords;
import com.eng.iso.sharipova.Entity.ExerciseJumpled;
import com.eng.iso.sharipova.Entity.ExerciseListenCheckUpAnswers;
import com.eng.iso.sharipova.Entity.ExerciseListenPictureMatch;
import com.eng.iso.sharipova.Entity.ExerciseListenTextMatchKey;
import com.eng.iso.sharipova.Entity.ExerciseMatchWords;
import com.eng.iso.sharipova.Entity.ExercisePickPic;
import com.eng.iso.sharipova.Entity.ExerciseRearrange;
import com.eng.iso.sharipova.Entity.ExerciseSynonyms;
import com.eng.iso.sharipova.Entity.ExerciseTest;
import com.eng.iso.sharipova.Entity.ExerciseTest4x;
import com.eng.iso.sharipova.Entity.ExerciseTrueOrFalse;
import com.eng.iso.sharipova.Entity.ExerciseTwoDefferientThink;
import com.eng.iso.sharipova.Entity.ExerciseUnderline;
import com.eng.iso.sharipova.Entity.ExerciseVocabulOwn;
import com.eng.iso.sharipova.Entity.ExerciseWordsFillWrite;
import com.eng.iso.sharipova.Entity.ExerciseWordsFillWriteAudio;
import com.eng.iso.sharipova.Entity.ExerciseWriteSenrences;
import com.eng.iso.sharipova.Entity.ExerciseWriteSentencesText;
import com.eng.iso.sharipova.Entity.TestVariant;
import com.eng.iso.sharipova.Entity.TestVariant4x;

import java.util.ArrayList;

/**
 * Created by developer on 13.02.2017.
 */

public class ExerciseManager {

    public static ArrayList<Exercise>  fillData( int lessonNumber){
        ArrayList<Exercise> exercises = new ArrayList<>();
        switch (lessonNumber){
            case 0:
                //1
                ExerciseUnderline exerciseUnderline = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("electronic machines, to accept, data, to process, to feed, memory, to calculate, screen, to perform,  output, capable, storing, to print, device, program,  to serve, logical, operations, forecast, , to solve,  to contain, capacity",","),
                        "COMPUTERS",
                        "A computer is a general purpose device that can be programmed to carry out a set of arithmetic or logical operations automatically. Since a sequence of operations can be readily changed, the computer can solve more than one kind of problem. The word computer comes from a Latin word which means to count. Computers are electronic machines which can accept data in a certain form, process data and give the results of the processing. There are three basic steps in the process: first, you feed data into the computer’s memory. Then, the computer performs a set of instructions and processes the data. Finally, you can see the results (the output) on the screen or in the printed form. The machine is capable of storing and manipulating numbers, letters, and characters. Computers for personal use come in all shapes and sizes, from tiny smart phones to PC (personal computer) towers.\n" +
                                "There are different types of Computer: 1.Micro Computer is self contained units and usually designed to use by one person at a time. 2.Mini Computer is usually designed to serve many users simultaneously, it is a medium size computer. 3.Mainframe Computer with large storage capacities and very high speed of processing as compared to micro or minicomputers. 4.Super Computers have extremely large storage capacity and computing speed which is at least 10 times faster than others.\n" +
                                "However, the word Computer originates from the word compute that means to calculate, now a day’s amazingly 80% + of work is done in computers even of non numerical nature like music composing, special effects, resume sorting, forecasting, nuclear research etc. Computer not only processes the data and makes you available the information but also able to perform the subsequent steps on the basis of processed information that’s why computer even something more than a data processing device.\n");
                exercises.add(exerciseUnderline);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> questions = new ArrayList<>();
                questions.add("What does the word computer mean?");
                questions.add("How many steps are there in the process?");
                questions.add("What is the machine capable of?");
                questions.add("What kinds of types of computer are mentioned in the text?");
                questions.add("What else is the computer able to?");
                exerciseAnswerQuestions.setQuestions(questions);
                exercises.add(exerciseAnswerQuestions);

                //3
                ExercisePickPic exersicePickPic = new ExercisePickPic("III Exercise",
                        "In the spaces on the right, write in the letter that matches to the computer part in the picture.",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPic.setPhotoName("les1_3");
                ArrayList<String> words = new ArrayList<>();
                words.add("Microphone");
                words.add("Mouse");
                words.add("Keyboard");
                words.add("Screen");
                words.add("Computer/CPU");
                words.add("Monitor");
                words.add("Speakers");
                exersicePickPic.setWords(words);
                exercises.add(exersicePickPic);


                //4
                ExerciseRearrange exerciseRearrange = new ExerciseRearrange("IV Exercise",
                        "Rearrange the letters to make things which can be part of  a workstation.",
                        ExerciseTypes.RERANGE_EX);
                ArrayList<String>  rewords = new ArrayList<>();
                rewords.add("nopelethe");
                rewords.add("hacir");
                rewords.add("kesd");
                rewords.add("nasecnr");
                exerciseRearrange.setRewords(rewords);
                exercises.add(exerciseRearrange);

                //5
                ExerciseTest exerciseTest= new ExerciseTest("V Exercise",
                        "Choose the best word",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestions = new ArrayList<>();
                ArrayList<TestVariant> testVariants = new ArrayList<>();
                testQuestions.add("You can increase the functions or performance of a computer with an __________.");
                testVariants.add(new TestVariant("extension card","exploding card","expansion card"));
                testQuestions.add("SD cards can be read in a computer's __________.");
                testVariants.add(new TestVariant("storage reader","memory reader","card reader"));
                testQuestions.add("…so you can plug in your mobile phone __________.");
                testVariants.add(new TestVariant("charger","power","electrification"));
                testQuestions.add("The computer is connected to the telephone line via a _____.");
                testVariants.add(new TestVariant("module","modem","mod"));
                testQuestions.add("To get sound from your computer, plug in a pair of _______.");
                testVariants.add(new TestVariant("loudhailers","loudspeakers","loud voices"));
                testQuestions.add("The mouse moves on a __________.");
                testVariants.add(new TestVariant("mouse mat","mouse carpet","mouse table"));
                testQuestions.add("Mobile phones and PDAs can communicate with computers via ____.");
                testVariants.add(new TestVariant("Bluebeard","Blueberry","Bluetooth"));
                testQuestions.add("There's a spare __________ in the workstation…");
                testVariants.add(new TestVariant("electric hole","power point","electrical opening"));
                testQuestions.add("Before you start work, __________ the height of your chair");
                testVariants.add(new TestVariant("adjust","change ","rearrange"));
                testQuestions.add("TV and computer screens are usually measured in ______.");
                testVariants.add(new TestVariant("feet","miles","inches"));
                exerciseTest.setQuestions(testQuestions);
                exerciseTest.setTestVariants(testVariants);
                exercises.add(exerciseTest);

                //6
                ExerciseListenPictureMatch exerciseListenPictureMatch = new ExerciseListenPictureMatch("VI Exercise",
                        "Listen to the text, look at the picture and match the description of the various hardware components of a desktop computer",
                        ExerciseTypes.PICT_PHOTO_EX);
                exerciseListenPictureMatch.setPhotoName("les1_6");
                exerciseListenPictureMatch.setAudioName("les1_6");
                exerciseListenPictureMatch.setCountWords(10);
                exercises.add(exerciseListenPictureMatch);

                //7
                ExerciseWriteSenrences exerciseWriteSenrences = new ExerciseWriteSenrences("VII Exercise",
                        "“What Are the Differences Between a Laptop and Desktop Computer?” with 6-8 sentences write down your ideas about it.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips = new ArrayList<>();
                usefullTips.add("....consists of.....");
                usefullTips.add(".......carries out....");
                usefullTips.add("The size of.......");
                usefullTips.add(".....is ultraportable....");
                exerciseWriteSenrences.setUsefullTips(usefullTips);
                exercises.add(exerciseWriteSenrences);
                //8
                ExerciseSynonyms exerciseSynonyms = new ExerciseSynonyms("VIII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms = new ArrayList<>();
                synonyms.add("electronic machines");
                synonyms.add("to accept ");
                synonyms.add("data");
                synonyms.add("to process");
                synonyms.add("to feed");
                synonyms.add("memory");
                synonyms.add("screen");
                synonyms.add("to perform");
                synonyms.add("output ");
                synonyms.add("to print");
                synonyms.add("input");
                synonyms.add("device");
                synonyms.add("accept");
                synonyms.add("supply");
                synonyms.add("provide");
                exerciseSynonyms.setWords(synonyms);
                exercises.add(exerciseSynonyms);

                //9
                ExerciseVocabulOwn exerciseVocabulOwn = new ExerciseVocabulOwn("IX Exervice",
                        "Put the text “COMPUTERS” into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn.setPhotoName("les1_9");
                exercises.add(exerciseVocabulOwn);

                break;
            case 1:
                //1
                ExerciseUnderline exerciseUnderline1 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("computer system, components, purpose,  to solve, hardware, software, machinery, functions,  manuals, listings, to require, items, typewriter, user, storage, central unit, Arithmetic Logic Unit, to decode, sequence, calculations, manipulation",","),
                        "COMPUTER SYSTEM",
                        "A computer system is one that is able to take a set of inputs, process them and create a set of outputs. This is done by a combination of hardware and software. The purpose of a computer system is to make it as easy as possible for you to use a computer to solve problems. The hardware elements are the mechanical devices in the system, the machinery and the electronics that perform physical functions. The software elements are the programs written for the system; these programs perform logical and mathematical operations and provide a means for you to control the system. Documentation includes the manuals and listings that tell you how to use the hardware and software. Collectively these components provide a complete computer system: system hardware + system software + system documentation = computer system. Usually, a computer system requires these basic hardware items: the computer, which performs all data processing; a terminal device, used like a typewriter for two-way communication between the user and the system; and a storage medium for storing programs and data.\n" +
                                "The computer system has one or more inputs to provide data. This data is then processed in some way. The outcome of the processing is sent to an output or it may be stored until some event happens to cause it to be output. \n" +
                                "For processing to take place, there needs to be a set of instructions of what needs to be done. This set of instruction is called a program. This system is called a stored program computer.\n" +
                                "The central processor has two main parts. They are the Control Unit (CU) and the Arithmetic Logic Unit (ALU).   The CU controls all the other units in the computer system. It decodes the program instructions and makes sure they are carried out in the correct sequence.  The ALU, on the other hand, performs the calculations and data manipulation, for example comparing, sorting and combining data.\n");

                exercises.add(exerciseUnderline1);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions1  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question1 = new ArrayList<>();
                question1.add("What is computer system?");
                question1.add("What makes easy to use computer for us?");
                question1.add("What is the difference between hardware and software?");
                question1.add("How can we use hardware and software?");
                question1.add("What are the hardware elements?");
                exerciseAnswerQuestions1.setQuestions(question1);
                exercises.add(exerciseAnswerQuestions1);

                //3
                ExercisePickPic exersicePickPic1 = new ExercisePickPic("III Exercise",
                        "Match the words with the picture",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPic1.setPhotoName("les2_3");
                ArrayList<String> words1 = new ArrayList<>();
                words1.add("battery");
                words1.add("plug");
                words1.add("socket");
                words1.add("digital camera");
                words1.add("mouse");
                words1.add("printer");
                words1.add("projector");
                words1.add("mobile phone");
                words1.add("docking station");
                words1.add("PDA (Personal Digital Assistant)");
                words1.add("cable");
                words1.add("fax machine");
                words1.add("desktop computer");
                words1.add("scanner");
                words1.add("laptop compute");
                exersicePickPic1.setWords(words1);
                exercises.add(exersicePickPic1);

                //4
                ExerciseMatchWords exerciseMatchWords = new ExerciseMatchWords("IV Exercise",
                        "Match the words",
                        ExerciseTypes.MATCH_WORDS_EX);
                ArrayList<String> firstCol = new ArrayList<>();
                firstCol.add("take some");
                firstCol.add("send and receive");
                firstCol.add("give");
                firstCol.add("dial");
                firstCol.add("move");
                firstCol.add("print out");
                firstCol.add("click on");
                firstCol.add("recharge");
                exerciseMatchWords.setFirstCollumb(firstCol);
                ArrayList<String> secondCol = new ArrayList<>();
                secondCol.add("digital photos");
                secondCol.add("faxes");
                secondCol.add("a number on your mobile phone");
                secondCol.add("a presentation");
                secondCol.add("something with the mouse");
                secondCol.add("the battery");
                secondCol.add("the mouse");
                secondCol.add("twenty pages");
                exerciseMatchWords.setFirstCollumb(secondCol);
                exercises.add(exerciseMatchWords);

                //5
                ExerciseAdvantagesDisadvantegs exerciseAdvantagesDisadvantegs = new ExerciseAdvantagesDisadvantegs("V Exercise",
                        "Fill in the gaps using the words below. Listen to the advantages and disadvantages of computers and  check up your answers.",
                        ExerciseTypes.ADVANTAGE_DISADVANTAGE_AUDIO_FILL_EX);
                exerciseAdvantagesDisadvantegs.setAdvantageTitle("Advantages of Computers:");
                exerciseAdvantagesDisadvantegs.setAdvantageText("It can ___. any repetitive work and ___. rapidly and accurately. Computers can ___. large amount of ___ and information for subsequent manipulation. The memory of computer can hold ___. which can be explored in different ways. Computers can make decision based on different conditions. It can ___. information to the ___. ");
                exerciseAdvantagesDisadvantegs.setDisadvantageTitle("Disadvantages of computers:");
                exerciseAdvantagesDisadvantegs.setDisadvantageText("A computer has no___. or___. of its own. It cannot learn with experience. It can only___. operations as instructed by the user. It has no..___. due to which it can carry out the___. only as long as user needs. It can understand instructions no matter whether they are right or wrong. ");
                ArrayList<String> advanWords = new ArrayList<>();
                advanWords.add("User");
                advanWords.add("perform");
                advanWords.add("data");
                advanWords.add("provide");
                advanWords.add("calculation");
                advanWords.add("store");
                advanWords.add("a program ");
                exerciseAdvantagesDisadvantegs.setAdvantageKeyWords(advanWords);
                ArrayList<String> disadvanWords = new ArrayList<>();
                disadvanWords.add("Intelligence");
                disadvanWords.add("brain");
                disadvanWords.add("instructions");
                disadvanWords.add("common sense");
                disadvanWords.add("perform");
                exerciseAdvantagesDisadvantegs.setDisadvantageKeyWords(disadvanWords);
                exercises.add(exerciseAdvantagesDisadvantegs);

                //6
                ExerciseSynonyms synonyms1 = new ExerciseSynonyms("VI Exercise",
                        "A PC system includes all the parts needed to make a  functioning computer. Write down “what do they include?”",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms2 = new ArrayList<>();
                synonyms2.add("Input devices");
                synonyms2.add("Computer");
                synonyms2.add("Output devices");
                synonyms2.add("Storage");
                synonyms1.setWords(synonyms2);
                exercises.add(synonyms1);

                //7
                ExerciseTest exerciseTest1= new ExerciseTest("VII Exercise",
                        "Choose the best verb",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestions1 = new ArrayList<>();
                ArrayList<TestVariant> testVariants1 = new ArrayList<>();
                testQuestions1.add("The printer has __________ of ink.");
                testVariants1.add(new TestVariant("finished","ended","run  out"));
                testQuestions1.add("To turn on the computer, __________ the \"Start\" button.");
                testVariants1.add(new TestVariant("touch","press","switch"));
                testQuestions1.add("Unfortunately, my scanner isn't __________ at the moment.");
                testVariants1.add(new TestVariant("working","going","doing"));
                testQuestions1.add("Please __________ the CD ROM.");
                testVariants1.add(new TestVariant("insert","introduce","inject"));
                testQuestions1.add("The projector isn't working because it isn't __________.");
                testVariants1.add(new TestVariant("plugged","plugged in","plugged into"));
                testQuestions1.add("The batteries in my digital camera are nearly dead. They need __.");
                testVariants1.add(new TestVariant("to change","exchanging","changing"));
                testQuestions1.add("I have to __________ a computer screen for eight hours a day.");
                testVariants1.add(new TestVariant("see","look at","watch"));
                testQuestions1.add("Switch off your computer, and _________ it from the wall socket.");
                testVariants1.add(new TestVariant("de-plug","unplug","non-plug"));
                testQuestions1.add("__________ any key to continue.");
                testVariants1.add(new TestVariant("Kick","Smash","Hit"));
                testQuestions1.add("I turned off the photocopier and ___________ the plug.");
                testVariants1.add(new TestVariant("pulled out","extracted","took away"));
                exerciseTest1.setQuestions(testQuestions1);
                exerciseTest1.setTestVariants(testVariants1);
                exercises.add(exerciseTest1);

                //8
                ExerciseSynonyms exerciseSynonyms1 = new ExerciseSynonyms("VI Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms3 = new ArrayList<>();
                synonyms3.add("computer system");
                synonyms3.add("collection");
                synonyms3.add("components");
                synonyms3.add("purpose");
                synonyms3.add("to combine");
                synonyms3.add("hardware");
                synonyms3.add("software");
                synonyms3.add("to require");
                synonyms3.add("items");
                synonyms3.add("typewriter");
                synonyms3.add("user");
                synonyms3.add("storage");
                synonyms3.add("to decode");
                synonyms3.add("calculations");
                synonyms3.add("manipulation");
                synonyms3.add("registers");
                synonyms3.add("access");
                synonyms3.add("speed");
                exerciseSynonyms1.setWords(synonyms3);
                exercises.add(exerciseSynonyms1);

                //9
                ExerciseVocabulOwn exerciseVocabulOwn1 = new ExerciseVocabulOwn("IX Exervice",
                        "Put the text  “COMPUTER SYSTEM”  into your own words using vocabulary",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn1.setPhotoName("les2_9");
                exercises.add(exerciseVocabulOwn1);

                break;
            case 2:
                //1
                ExerciseUnderline exerciseUnderline2 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("to press, an arrangement, mechanical levers, electronic switches, derive, layout, typewriter, to enter, edit, to depend on, frequently, to attach, shut down, appearance, additional, to bring up",","),
                        "Keyboard",
                        "A computer keyboard is an input device used to enter characters and functions into the computer system by pressing buttons, or keys. It is the primary device used to enter text. In computing, a keyboard is a typewriter keyboard, which uses an arrangement of buttons or keys, to act as mechanical levers or electronic switches. Most keyboards have a very similar layout. The individual keys for letters, numbers and special characters are collectively called the character keys. The layout of these keys is derived from the original layout of keys on a typewriter. The most widely used layout in the English language is called QWERTY, named after the sequence of the first six letters from the top left. Other sets of keys common to almost all keyboards are entering and editing keys (e.g., Enter, Delete, Insert), modifier keys (e.g., Control, Shift), navigation keys (e.g., arrows for up, down, left, right) and lock keys (e.g., Caps Lock). Additional keys are very operating system specific (such as the Windows and Apple keys). Most keyboards also include a set of function keys at the top (F1, F2, etc.). The function keys typically perform a very specific task within a particular software application. So, what they do may depend on what you are doing on your computer at the time. A keyboard is also used to give commands to the operating system of a computer, such as Windows' Control-Alt-Delete combination, which brings up a task window or shuts down the machine. It is the only way to enter commands on a command-line interface. Keyboards vary in appearance. Those attached to a desktop computer are frequently large with an additional number pad built in on the right side, while laptop keyboards are attached to the computer and are often much smaller. Some keyboards also offer special buttons to control the mouse on the screen or to play music.");
                exercises.add(exerciseUnderline2);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions2  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question2 = new ArrayList<>();
                question2.add("What kind of device is a keyboard?");
                question2.add("What is keyboard used for?");
                question2.add("What is QWERTY?");
                question2.add("For what purposes are computer keyboards used?");
                question2.add("How do they vary in appearance?");
                exerciseAnswerQuestions2.setQuestions(question2);
                exercises.add(exerciseAnswerQuestions2);

                //3
                ExerciseComWordsFillWrite exersiceComWordsFillWrite = new ExerciseComWordsFillWrite("III Exercise",
                        "Match the words with the picture and fill in the gaps using these words and word combinations",
                        ExerciseTypes.COM_PIC_PICK_FILL_GAP_EX);
                exersiceComWordsFillWrite.setPhotoName("les3_3");
                ArrayList<String> keywords = new ArrayList<>();
                keywords.add("tab key");
                keywords.add("function keys");
                keywords.add("alt key");
                keywords.add("delete key");
                keywords.add("alphabet keys");
                keywords.add("enter key");
                keywords.add("shift key");
                keywords.add("space bar");
                keywords.add("ergonomic keyboard");
                keywords.add("backspace key");
                keywords.add("indicator lights");
                keywords.add("control key");
                keywords.add("caps lock key");
                keywords.add("key in (or type in)");
                keywords.add("data input");
                keywords.add("enter");
                keywords.add("escape key");
                keywords.add("calculator keys");
                exersiceComWordsFillWrite.setWords(keywords);

                ArrayList<String> gaps = new ArrayList<>();
                gaps.add("To go back one space, hit the _______________. ");
                gaps.add("To change to capital letters, press the _______________.");
                gaps.add("To change the capital letters permanently, hit the ____________.");
                gaps.add("To insert a tabulation, press the _______________.");
                gaps.add("To activate the \"Ctrl\" functions, press the  _______________.");
                gaps.add("To activate the \"alt\" functions, hit the _______________.");
                gaps.add("To stop the computer doing something, you can press the __________");
                gaps.add("Select the text you want to remove, and hit the  _______________.");
                gaps.add("Please _______________ your password.");
                gaps.add("It took me two hours to _______________ all that text.");
                gaps.add("A keyboard is a _______________ device.");
                gaps.add("Do you have a _______________? \n No. I have a special _______________. It's better for my arms and back.");
                exersiceComWordsFillWrite.setGaps(gaps);
                exersiceComWordsFillWrite.setCountPick(6);

                exercises.add(exersiceComWordsFillWrite);


                //4
                ExerciseListenTextMatchKey exerciseListenTextMatchKey = new ExerciseListenTextMatchKey("IV Exercise",
                        "Listen to the description of “Keys” special functions and define which function does each button do? ",
                        ExerciseTypes.LISTEN_TEXT_MATCH_KEY);
                ArrayList<String> keywordss= new ArrayList<>();
                keywordss.add("Esc");
                keywordss.add("Backspace");
                keywordss.add("Tab");
                keywordss.add("Tab");
                keywordss.add("Tab");
                keywordss.add("End");
                keywordss.add("Ctrl (Control)");
                keywordss.add("PgUp (Page up)");
                keywordss.add("PgDn (Page Down)");
                keywordss.add("Alt (Alternate)");
                exerciseListenTextMatchKey.setKeyWords(keywordss);
                exerciseListenTextMatchKey.setAudioName("les3_4");
                ArrayList<String> texts = new ArrayList<>();
                texts.add("This key is used to send the cursor to the beginning of the next line (for instance when typing text in a word processing package). It is also used to finish a command to tell the computer to execute the command just typed. There are usually two of these keys.");
                texts.add("Used to delete one character at a time to the left of the cursor. You can also click and drag to highlight text and then press this key to delete text.");
                texts.add("Used to set tab position in a document. Setting tab position allows you to move the cursor to defined positions, for instance when typing figures in columns. By holding down the Shift key then pressing this key, you can move to the previous ....position.");
                texts.add("Hold down this key and press a letter, to get an upper case letter, or press any other key, e.g. a number, to get the symbol above it.  Some keyboard shortcuts also use this key.");
                texts.add("Primarily used to cancel a command (instead of pressing Enter) or to escape from a process which may be in  odd state.");
                texts.add("Used in conjunction with other keys to carry out function specific to your computer system. Also used to enter ASCII codes, including non-English characters, by holding down this key and entering the number from the numeric keypad.");
                texts.add("Cannot be used on its own. Used in conjunc-tion with other keys to carry out a specific function. There are usually two of these keys.");
                texts.add("Moves your cursor up one page of information.");
                texts.add("Moves your cursor down one page of information.");
                texts.add("Moves your cursor to the end of the current line of typed character.");
                exerciseListenTextMatchKey.setTexts(texts);
                exercises.add(exerciseListenTextMatchKey);

                //5
                ExerciseTest4x exerciseTest2= new ExerciseTest4x("V Exercise",
                        "Choose the right answer",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestions2 = new ArrayList<>();
                ArrayList<TestVariant4x> testVariants2 = new ArrayList<>();
                testQuestions2.add("Which part is the \"brain\" of the computer?");
                testVariants2.add(new TestVariant4x("Monitor","RAM","CPU","ROM"));
                testQuestions2.add("What is the permanent memory built into your computer called?");
                testVariants2.add(new TestVariant4x("RAM","ROM","CPU","CD-ROM"));
                testQuestions2.add("Approximately how many bytes make one Megabyte");
                testVariants2.add(new TestVariant4x("One Thousand","Ten Thousand","One Million","One Hundred"));
                testQuestions2.add("The capacity of your hard drive is measured in");
                testVariants2.add(new TestVariant4x("MHz","Gigabytes","Mbps","52X"));
                testQuestions2.add("Which of the following is not an input device?");
                testVariants2.add(new TestVariant4x("Keyboard","Monitor","Joystick","Microphone"));
                testQuestions2.add("Which of the following is not an output device?");
                testVariants2.add(new TestVariant4x("Monitor","Printer","Speakers","Keyboard"));
                testQuestions2.add("Which device allows your computer to talk to other computers  over a telephone line as well as access the internet?");
                testVariants2.add(new TestVariant4x("RAM","CD-ROM drive","Hard Drive","Modem"));
                testQuestions2.add("How much information can a CD (Compact Disk) usually store?");
                testVariants2.add(new TestVariant4x("650 Mb","1.4 Mb","150 Mb","10 Mb"));
                exerciseTest2.setQuestions(testQuestions2);
                exerciseTest2.setTestVariants(testVariants2);
                exercises.add(exerciseTest2);

                //6
                ExerciseWriteSenrences exerciseWriteSenrences1 = new ExerciseWriteSenrences("VI Exercise",
                        "Left,Bottom,Top,Right Cursor control keys. Write down the functions of these keys.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips1 = new ArrayList<>();
                usefullTips1.add(".....is an input device....");
                usefullTips1.add("....right cursor…");
                usefullTips1.add("…. control key...");
                usefullTips1.add("....is used to.....");
                usefullTips1.add("....is used to.....");
                usefullTips1.add("...moves your cursor....");
                exerciseWriteSenrences1.setUsefullTips(usefullTips1);
                exercises.add(exerciseWriteSenrences1);

                //7
                ExerciseSynonyms exerciseSynonyms2 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms4 = new ArrayList<>();
                synonyms4.add("mechanical levers");
                synonyms4.add("electronic switches");
                synonyms4.add("teletype-style keyboards");
                synonyms4.add("input device");
                synonyms4.add("to vary");
                synonyms4.add("touch sensitive screens");
                synonyms4.add("to expedite");
                synonyms4.add("frequently");
                synonyms4.add("keystroke");
                synonyms4.add("shut down");
                exerciseSynonyms2.setWords(synonyms4);
                exercises.add(exerciseSynonyms2);
                //8
                ExerciseVocabulOwn exerciseVocabulOwn2 = new ExerciseVocabulOwn("VIII Exervice",
                        "Put the text  “Keyboard”  into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn2.setPhotoName("les3_9");
                exercises.add(exerciseVocabulOwn2);
                break;
            case 3:
                //1
                ExerciseUnderline exerciseUnderline3 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("a scroll wheel, a pointing device, the cursor, feature, a button, motion, interface, two-dimensional, a surface, spring-loaded, lightly, to Click, bound, a text file, to hover",","),
                        "Mouse",
                        "What makes the mouse especially useful is that it is a very quick way to move around on a screen. The mouse also issues instructions to the computer very quickly. Point to an available option with the cursor, click on the mouse, and the option has been chosen. A computer mouse has the most common standard features: two buttons and a scroll wheel, which can also act as a third button. In computing, a mouse is a pointing device that functions by detecting two-dimensional motion relative to its supporting surface. Physically, a mouse consists of an object held under one of the user's hands, with one or more buttons. (Although traditionally a button is typically round or square, modern mice have spring-loaded regions of their top surface that operate switches when pressed down lightly.) It sometimes features other elements, such as \"wheels\", which allow the user to perform various system-dependent operations, or extra buttons or features that can add more control or dimensional input. The mouse's motion typically translates into the motion of a cursor on a display, which allows for fine control of a graphical user interface.\n" +
                                "Different ways of operating the mouse typically controls the motion of a cursor in two dimensions in a graphical user interface (GUI). Clicking or hovering (stopping movement while the cursor is within the bounds of an area) can select files, programs or actions from a list of names, or (in graphical interfaces) through small images called \"icons\" and other elements. For example, a text file might be represented by a picture of a paper notebook, and clicking while the cursor hovers this icon might cause a text editing program to open the file in a window.\n");
                exercises.add(exerciseUnderline3);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions3  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question3 = new ArrayList<>();
                question3.add("What common features does a computer mouse have?");
                question3.add("What kind of device is a mouse in computing?");
                question3.add("Why are extra buttons used for?");
                question3.add("What does a mouse control?");
                question3.add("What is GUI?");
                exerciseAnswerQuestions3.setQuestions(question3);
                exercises.add(exerciseAnswerQuestions3);


                //3

                ExerciseComWordsFillWrite exersiceComWordsFillWrite1 = new ExerciseComWordsFillWrite("III Exercise",
                        "Match the words with the picture and fill in the gaps using these words and word combinations",
                        ExerciseTypes.COM_PIC_PICK_FILL_GAP_EX);
                exersiceComWordsFillWrite1.setPhotoName("les4_3");
                ArrayList<String> keywords1 = new ArrayList<>();
                keywords1.add("pointer");
                keywords1.add("scroll up");
                keywords1.add("right button");
                keywords1.add("scroll wheel");
                keywords1.add("on");
                keywords1.add("scroll down");
                keywords1.add("joystick");
                keywords1.add("hold down");
                keywords1.add("optical");
                keywords1.add("touchpad");
                keywords1.add("single");
                keywords1.add("repetitive strain injury");
                keywords1.add("roll");
                keywords1.add("left button");
                keywords1.add("double");

                exersiceComWordsFillWrite1.setWords(keywords1);

                ArrayList<String> gaps1 = new ArrayList<>();
                gaps1.add("______________ to see pages above.");
                gaps1.add("______________ to see pages below.");
                gaps1.add("To select text, ______________ the left button, and move the mouse pointer.");
                gaps1.add("If you use a mouse for many hours every day, you can get ______________ in your fingers.");
                gaps1.add("With a laptop computer, plug in a mouse, or use the ______________ in front of the keyboard.");
                gaps1.add("To play some games, you need to use a ______________ instead of a mouse.");
                gaps1.add("To move up and down a page, you can ______________ the mouse wheel.");
                gaps1.add("This mouse doesn't have a ball. It's an ______________ mouse.");
                gaps1.add("One click of a mouse button is called a ______________ click.");
                gaps1.add("Two clicks of a mouse button are called a ______________ click.");
                gaps1.add("Click ______________ the folder to open it.");
                exersiceComWordsFillWrite1.setGaps(gaps1);
                exersiceComWordsFillWrite1.setCountPick(4);
                exercises.add(exersiceComWordsFillWrite1);

                //4
                ExerciseJumpled exerciseJumpled = new ExerciseJumpled("IV Exercise",
                        "Put the jumbled part of the sentences in the right order.",
                        ExerciseTypes.JUMPED_KEY);
                ArrayList<String> jumpleds= new ArrayList<>();
                jumpleds.add("The, very, issues, also, to, the, computer, instructionsmouse, quickly");
                jumpleds.add("A, held, an, object, of, one, of, the, user's, under, mouse, consists, hands");
                jumpleds.add("a, common, does, computer, features, mouse, have, What,?");
                jumpleds.add("typically, a, display, cursor, The , motion, of, the, motion, a, on, mouse's, into, translates");
                jumpleds.add("be, notebook, of, represented, A, text, might, by, a, picture, a, file,");
                jumpleds.add("is, mouse, What, computing, device, a, inkind, of, ?");
                exerciseJumpled.setJumpleds(jumpleds);
                exercises.add(exerciseJumpled);

                //5
                ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswers = new ExerciseListenCheckUpAnswers("V Exercise",
                        "Listen and check up your answers.",ExerciseTypes.LISTENING_ANSWER_KEY, "les4_5");
                exercises.add(exerciseListenCheckUpAnswers);

                //6
                ExerciseWriteSentencesText exerciseWriteSenrences3 = new ExerciseWriteSentencesText("VI Exercise",
                        "Read the text and write a summary.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                exerciseWriteSenrences3.setText("Cordless or wireless mice transmit data via infrared radiation (see IrDA) or radio (including Bluetooth and Wi-Fi). The receiver is connected to the computer through a serial or USB port, or can be built in (as is sometimes the case with Bluetooth and WiFi). Modern non-Bluetooth and non-WiFi wireless mice use USB receivers. Some of these can be stored inside the mouse for safe transport while not in use, while other, newer mice use newer \"nano\" receivers, designed to be small enough to remain plugged into a laptop during transport, while still being large enough to easily remove. The signals used for mice are different from those used for joysticks. As a result, plugging a mouse into a joystick port causes the \"joystick\" to continuously move in some direction, even if the mouse stays still, whereas plugging a joystick into a mouse port causes the \"mouse\" to only be able to move a single pixel in each direction.");
                ArrayList<String> usefullTips3 = new ArrayList<>();
                usefullTips3.add("This text is about ……");
                usefullTips3.add("……..is/are considered");
                usefullTips3.add("…..in this text");
                usefullTips3.add("……is/are also regarded in the given text.");
                usefullTips3.add("It is also said that…… in this text.");
                exerciseWriteSenrences3.setUsefullTips(usefullTips3);
                exercises.add(exerciseWriteSenrences3);

                //7
                ExerciseSynonyms exerciseSynonyms4 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms5 = new ArrayList<>();
                synonyms5.add("standard features");
                synonyms5.add("a scroll wheel");
                synonyms5.add("a pointing device");
                synonyms5.add("two-dimensional motion");
                synonyms5.add("supporting surface");
                synonyms5.add("clicking or hovering");
                synonyms5.add("system-dependent operations");
                synonyms5.add("the cursor");
                synonyms5.add("to click");
                synonyms5.add("a button");
                synonyms5.add("two-dimensional");
                synonyms5.add("motion");
                synonyms5.add("a surface");
                synonyms5.add("spring-loaded");
                synonyms5.add("a text file");
                synonyms5.add("to hover");
                exerciseSynonyms4.setWords(synonyms5);
                exercises.add(exerciseSynonyms4);

                //8
                ExerciseVocabulOwn exerciseVocabulOwn3 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text “Mouse” into your own words using  vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn3.setPhotoName("les4_8");
                exercises.add(exerciseVocabulOwn3);
                break;

            case 4:
                //1
                ExerciseUnderline exerciseUnderline4 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("the enclosure, to contain, floppy drive, power supply,  to construct, consequently, specific, the internal dimensions, layout, rack-mounted, blade server, external, card reader,size,  shape",","),
                        "A computer case",
                        "A computer case (also known as a computer chassis, cabinet, box, tower, enclosure, housing, system unit or simply case) is the enclosure that contains most of the components of a computer Everything including the motherboard, the hard drive, the cd drive, the floppy drive and the power supply go inside a computer case.\n" +
                                "Computer desktop cases generally have trays for the CD/DVD drives, floppy drives and hard drives. There is also a place for the power supply and the on-switch cables which usually come with the case. These are connected with the buttons at the front and these connect to pins on the motherboard. Cases are usually constructed from steel (often SECC—Steel, Electrically Chromate Coated) or aluminum. Plastic is sometimes used, and other materials such as wood and even Lego blocks have appeared in home-built cases. \n" +
                                "Cases can come in many different sizes (known as form factors). The size and shape of a computer case is usually determined by the form factor of the motherboard, since it is the largest component of most computers. Consequently, personal computer form factors typically specify only the internal dimensions and layout of the case. Form factors for rack-mounted and blade servers may include precise external dimensions as well, since these cases must themselves fit in specific enclosures. A few years ago, desktop computer cases were just plain. However, today for a little bit more money you can get computers with cool designs and colors. Some computer cases now come with front USB (Universal Serial Bus) and some even have a card reader, firewire or ports for a headset. \n");
                exercises.add(exerciseUnderline4);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions4  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question4 = new ArrayList<>();
                question4.add("What is a computer case?");
                question4.add("What are cases usually constructed from?");
                question4.add("What is the size and shape of a computer case usually determined by?");
                question4.add("What are full-size tower cases and desktop cases?");
                question4.add("What can you tell about nowadays computer case?");
                exerciseAnswerQuestions4.setQuestions(question4);
                exercises.add(exerciseAnswerQuestions4);

                //3
                ExerciseWordsFillWrite exersiceWordsFillWrite = new ExerciseWordsFillWrite("II Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_GAP_EX);
                ArrayList<String> keywordss2 = new ArrayList<>();
                keywordss2.add("disconnect");
                keywordss2.add("overheating");
                keywordss2.add("supply");
                keywordss2.add("fan");
                keywordss2.add("shock");
                keywordss2.add("surge protector");
                keywordss2.add("mains electricity");
                keywordss2.add("spikes");
                keywordss2.add("transformer");
                exersiceWordsFillWrite.setWords(keywordss2);

                ArrayList<String> gapss = new ArrayList<>();
                gapss.add("Laptops are powered by batteries or ____________.");
                gapss.add("Mains electricity is converted to lower voltage by a ___________.");
                gapss.add("A _________ protects electronic equipment from damage caused by power ____________.");
                gapss.add("If you remove the cover from a computer, make sure you ________ the electricity ___________. Otherwise, you may get an electric __________.");
                exersiceWordsFillWrite.setGaps(gapss);
                exercises.add(exersiceWordsFillWrite);

                //4
                ExercisePickPic exersicePickPicc = new ExercisePickPic("IV Exercise",
                        "Match the words with the picture",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPicc.setPhotoName("les5_4");
                ArrayList<String> wordss = new ArrayList<>();
                wordss.add("fan");
                wordss.add("motherboard");
                wordss.add("connectors");
                wordss.add("hard disc drive");
                wordss.add("expansion slots");
                wordss.add("optical drive");
                wordss.add("power supply and fan");
                exersicePickPicc.setWords(wordss);
                exercises.add(exersicePickPicc);

                //5
                ExerciseWordsFillWriteAudio exersiceWordsFillWrite11 = new ExerciseWordsFillWriteAudio("V Exercise",
                        "Fill in the blanks using the words and word combinations which are given in the box. Listen to the text and check up your answers.",
                        ExerciseTypes.FILL_TEXT_AUDIO_EX);
                ArrayList<String> keywordss22 = new ArrayList<>();
                keywordss22.add("computer case");
                keywordss22.add("vertically");
                keywordss22.add("various components");
                keywordss22.add("motherboard");
                keywordss22.add("components");
                keywordss22.add("memory");
                exersiceWordsFillWrite11.setWords(keywordss22);
                exersiceWordsFillWrite11.setText("Once you open up a ........, it can initially be difficult to recognize the........, especially all the different wires. However,  you look closely, you will probably start to recognize a number of .......... \n" +
                        "In this particular example, the motherboard is placed......, which is quite common. One side of the........ is accessible from the back of the computer case - this includes the various connectors for input and output devices as well as expansion slots for additional peripherals. The motherboard also contains the central processing unit (CPU), although it can be difficult to see. A large fan is often placed on top of the CPU to avoid overheating. The motherboard also contains the main ....... of the computer.");
                exersiceWordsFillWrite11.setAudioName("les5_5");
                exercises.add(exersiceWordsFillWrite11);
                //6
                ExerciseWriteSenrences exerciseWriteSenrences2 = new ExerciseWriteSenrences("VI Exercise",
                        "Listen to the text again and write down a summary.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips2 = new ArrayList<>();
                usefullTips2.add("This can be seen……");
                usefullTips2.add("……..is/are clearly shown");
                usefullTips2.add("…..in this text");
                usefullTips2.add("It is obvious that......");
                usefullTips2.add("Following the analyzing of.........");
                exerciseWriteSenrences2.setUsefullTips(usefullTips2);
                exercises.add(exerciseWriteSenrences2);

                //7
                ExerciseSynonyms exerciseSynonyms5 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms6 = new ArrayList<>();
                synonyms6.add("home-built cases");
                synonyms6.add("the size and shape of a computer case");
                synonyms6.add("business environments");
                synonyms6.add("power supply");
                synonyms6.add("the enclosure");
                synonyms6.add("to determine");
                synonyms6.add("to specify");
                synonyms6.add("the internal dimensions");
                synonyms6.add("expansion slots");
                exerciseSynonyms5.setWords(synonyms6);
                exercises.add(exerciseSynonyms5);

                //8
                ExerciseVocabulOwn exerciseVocabulOwn4 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text  “A computer case”  into your own words  using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn4.setPhotoName("les5_8");
                exercises.add(exerciseVocabulOwn4);

                break;
            case 5:
                //1
                ExerciseUnderline exerciseUnderline5 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("crucial components, non-conductive material, sockets and slots, a backplane, to provide, electrical connection, subsystem, essential, external storage, plug-in card, via, although, to integrate, a support, various, socket, to be installed, non-volatile memory chips, firmware, expansion card, to distribute, to receive",","),
                        "A motherboard",
                        "A motherboard is one of the most essential parts of a computer system. It holds together many of the crucial components of a computer, including the central processing unit (CPU), memory and connectors for input and output devices. The base of a motherboard consists of a very firm sheet of non-conductive material, typically some sort of rigid plastic. Thin layers of copper or aluminum foil, referred to as traces, are printed onto this sheet. These traces are very narrow and form the circuits between the various components. In addition to circuits, a motherboard contains a number of sockets and slots to connect the other components. \n" +
                                "A motherboard, like a backplane, provides the electrical connections by which the other components of the system communicate, but unlike a backplane, it also connects the central processing unit and hosts other subsystems and devices.\n" +
                                "A typical desktop computer has its microprocessor, main memory, and other essential components connected to the motherboard. Other components such as external storage, controllers for video display and sound, and peripheral devices may be attached to the motherboard as plug-in cards or via cables, although in modern computers it is increasingly common to integrate some of these peripherals into the motherboard itself.\n" +
                                "An important component of a motherboard is the microprocessor's supporting chipset, which provides the supporting interfaces between the CPU and the various buses and external components. This chipset determines, to an extent, the features and capabilities of the motherboard.\n" +
                                "Modern motherboards include, at a minimum:\n" +
                                "•\tsockets (or slots) in which one or more microprocessors may be installed\n" +
                                "•\tslots into which the system's main memory is to be installed (typically in the form of DIMM modules containing DRAM chips)\n" +
                                "•\ta chipset which forms an interface between the CPU's front-side bus, main memory, and peripheral buses\n" +
                                "•\tnon-volatile memory chips (usually Flash ROM in modern motherboards) containing the system's firmware or BIOS\n" +
                                "•\ta clock generator which produces the system clock signal to synchronize the various components\n" +
                                "•\tslots for expansion cards (these interface to the system via the buses supported by the chipset)\n" +
                                "power connectors, which receive electrical power from the computer power supply and distribute it to the CPU, chipset, main memory, and expansion cards.\n");
                exercises.add(exerciseUnderline5);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions5  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question5 = new ArrayList<>();
                question5.add("What does a motherboard hold together?");
                question5.add("What does a motherboard provide?");
                question5.add("What components does typical desktop computer have?");
                question5.add("What is an important component of a motherboard?");
                question5.add("What do modern motherboards include?");
                exerciseAnswerQuestions5.setQuestions(question5);
                exercises.add(exerciseAnswerQuestions5);

                //3
                ExercisePickPic exersicePickPicc1 = new ExercisePickPic("III Exercise",
                        "Match the words with the picture",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPicc1.setPhotoName("les6_3");
                ArrayList<String> wordss1 = new ArrayList<>();
                wordss1.add("CPU socket");
                wordss1.add("Power connector");
                wordss1.add("PCI slots");
                wordss1.add("DRAM memory slots");
                wordss1.add("Hard drive slots");
                wordss1.add("Connectors for peripherals ");
                wordss1.add("Southbridge");
                wordss1.add("AGP slot");
                wordss1.add("ROM");
                wordss1.add("Northbridge with heat sink");
                wordss1.add("Backup battery");
                wordss1.add("CPU heat sinks and mounting points for fans");
                exersicePickPicc1.setWords(wordss1);
                exercises.add(exersicePickPicc1);

                //4
                ExerciseJumpled exerciseJumpled1 = new ExerciseJumpled("IV Exercise",
                        "Put the jumbled part of the sentences in the right order.",
                        ExerciseTypes.JUMPED_KEY);
                ArrayList<String> jumpleds1= new ArrayList<>();
                jumpleds1.add("contains, of, sockets, and, to, connect, the, a, motherboard,   a number, other, components, slots");
                jumpleds1.add("connects, central, and,  subsystems, and, A motherboard, processing, hosts, unit, other, devices, the");
                jumpleds1.add("components, does, typical, What, desktop, computer, have,?");
                jumpleds1.add("important, of, a, the,  microprocessor's, component, chipset, An, supporting, motherboard, is");
                jumpleds1.add("size, and, factor, shape, of, computer, the, case, is determined, a, by, form, of, motherboard, The, usually, the");
                exerciseJumpled1.setJumpleds(jumpleds1);
                exercises.add(exerciseJumpled1);

                //5
                ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswers2 = new ExerciseListenCheckUpAnswers("V Exercise",
                        "Listen and check up your answers.",ExerciseTypes.LISTENING_ANSWER_KEY, "les6_5");
                exercises.add(exerciseListenCheckUpAnswers2);

                //6
                ExerciseWriteSenrences exerciseWriteSenrences4 = new ExerciseWriteSenrences("VI Exercise",
                        "Look at the diagram and write your own idea between all these  connections.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips4 = new ArrayList<>();
                usefullTips4.add("....essential parts of.....");
                usefullTips4.add("iticludes.....devices");
                usefullTips4.add("..., it also connects.....");
                usefullTips4.add("...components like....");
                usefullTips4.add("....is used for.....");
                exerciseWriteSenrences4.setUsefullTips(usefullTips4);

                //7
                ExerciseSynonyms exerciseSynonyms6 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms7 = new ArrayList<>();
                synonyms7.add("a backplane");
                synonyms7.add("components of the system");
                synonyms7.add("the central processing unit");
                synonyms7.add("subsystems and devices");
                synonyms7.add("main memory");
                synonyms7.add("essential components");
                synonyms7.add("external storage");
                synonyms7.add("controllers for video display");
                synonyms7.add("peripheral devices");
                synonyms7.add("as plug-in cards");
                synonyms7.add("the microprocessor's supporting chipset");
                synonyms7.add("buses and external components");
                synonyms7.add("subsystem");
                synonyms7.add("to distribute");
                exerciseSynonyms6.setWords(synonyms7);
                exercises.add(exerciseSynonyms6);


                //8
                ExerciseVocabulOwn exerciseVocabulOwn5 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text  “A motherboard”  into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn5.setPhotoName("");
                exercises.add(exerciseVocabulOwn5);

                break;
            case 6:
                //1
                ExerciseUnderline exerciseUnderline6 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("video adapter, graphics accelerator, an expansion card, to generate, an offer, added functions, rendering, to capture, TV-tuner adapter, to occur, to include, flat screen, fan/heatsink combinations, graphics card, processing, to generate, niche",","),
                        "A video card",
                        "A video card connects to the motherboard of a computer system and generates output images to display. Video cards are also referred to as graphics cards. Video cards include a processing unit, memory, a cooling mechanism and connections to a display device.\n" +
                                "A video card, video adapter, graphics accelerator card, display adapter, or graphics card is an expansion card whose function is to generate output images to a display. Many video cards offer added functions, such as accelerated rendering of 3D scenes and 2D graphics, video capture, TV-tuner adapter, MPEG-2/MPEG-4 decoding, FireWire, light pen, TV output, or the ability to connect multiple monitors (multi-monitor). Other modern high performance video cards are used for more graphically demanding purposes, such as PC games.\n" +
                                "Video hardware can be integrated on the motherboard, often occurring with early machines. In this configuration it is sometimes referred to as a video controller or graphics controller. Video cards usually come with at least a couple of different types of ports for connecting display devices.  The most common ones today are standard VGA (found on nearly every monitor), HDMI (high definition multimedia interface) and DVI (digital visual interface) which are the predominant protocols in mid to higher end monitors and flat screen tvs.  S-Video can also be found on some niche specific cards.\n" +
                                "The final component is the heatsink/fan.  All video cards will some type of heatsink attached to them to reduce the chances of the GPU overheating.  Higher end video cards will have larger heatsinks or even fan/heatsink combinations as they tend to generate more heat or are installed in higher end computers that also tend to generate more heat.\n");
                exercises.add(exerciseUnderline6);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions6  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question6 = new ArrayList<>();
                question6.add("What is the function of a video card?");
                question6.add("What kind of added functions do many video cards offer?");
                question6.add("What are modern high performance video cards used for?");
                question6.add("Where can video hardware be integrated?");
                question6.add("What is the final component of a video card?");
                exerciseAnswerQuestions6.setQuestions(question6);
                exercises.add(exerciseAnswerQuestions6);

                //3
                ExercisePickPic exersicePickPicc2 = new ExercisePickPic("III Exercise",
                        "Match the words and the word combination with the picture",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPicc2.setPhotoName("les7_3");
                ArrayList<String> wordss2 = new ArrayList<>();
                wordss2.add("Memory");
                wordss2.add("GPU with heat sink");
                wordss2.add("Connection to motherboard");
                wordss2.add("Connections to display devices");
                exersicePickPicc2.setWords(wordss2);
                exercises.add(exersicePickPicc2);

                //4
                ExerciseFillTextWords exerciseFillTextWords = new ExerciseFillTextWords("IV Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_TEXT_WITH_WORDS_EX);
                exerciseFillTextWords.setText("The \"brain\" of a computer is the _________. Most of these are made by Intel and AMD, and are sometimes referred to as \"_________\". The fastest processors are _________, which means that there are two processors working together. The  __________ of a processor is measured in   ________, which is usually written as MHz. A computer's memory is measured in _________. If a computer has 1,024 megabytes of memory, this is written as 1,024 MB and is pronounced as thousand and twenty-four megabytes ess-dee-dram. The processor and memory modules are located on the __________. Changing a computer's processor is not generally practical, but memory can usually be ___________.");
                ArrayList<String> wordsss = new ArrayList<>();
                wordsss.add("chips");
                wordsss.add("motherboard");
                wordsss.add("dual core");
                wordsss.add("processor");
                wordsss.add("megabytes");
                wordsss.add("speed");
                wordsss.add("megahertz");
                wordsss.add("upgraded");
                exerciseFillTextWords.setWords(wordsss);
                exercises.add(exerciseFillTextWords);
                //5
                ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswers3 = new ExerciseListenCheckUpAnswers("V Exercise",
                        "Listen and check up your answers.",ExerciseTypes.LISTENING_ANSWER_KEY, "les7_5");
                exercises.add(exerciseListenCheckUpAnswers3);

                //6
                ExerciseWriteSenrences exerciseWriteSenrences5 = new ExerciseWriteSenrences("VI Exercise",
                        "Are you playing graphically intensive games that have to be on the lowest video settings to be playable without “chugging (frequent pauses in the action where the computer has to  catch up)”?  Answer this question in written form.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips5 = new ArrayList<>();
                usefullTips5.add("...controlling output....");
                usefullTips5.add("...connects....");
                usefullTips5.add("....generates….");
                usefullTips5.add("...offer .....functions");
                usefullTips5.add("..is/are measured in...");
                exerciseWriteSenrences5.setUsefullTips(usefullTips5);
                exercises.add(exerciseWriteSenrences5);
                //7
                ExerciseSynonyms exerciseSynonyms7 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms8 = new ArrayList<>();
                synonyms8.add("graphics card");
                synonyms8.add("output image");
                synonyms8.add("modern low-end to mid-range motherboards");
                synonyms8.add("graphics chipset");
                synonyms8.add("embedded memory ");
                synonyms8.add("the integrated graphics chip");
                synonyms8.add("the performance limitations");
                synonyms8.add("video adapter");
                synonyms8.add("an expansion card");
                synonyms8.add("to generate");
                synonyms8.add("offer ");
                synonyms8.add("to capture ");
                synonyms8.add("reducing");
                synonyms8.add("to generate");
                exerciseSynonyms7.setWords(synonyms8);
                exercises.add(exerciseSynonyms7);

                //8
                ExerciseVocabulOwn exerciseVocabulOwn6 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text  “A video card”  into your own words using  vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn6.setPhotoName("les7_8");
                exercises.add(exerciseVocabulOwn6);
                break;
            case 7:
                //1
                ExerciseUnderline exerciseUnderline7 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("peripheral, attached, wireless, to support, feature, consumer, virtually, to achieve, inexpensive, relatively, offset, convenience, quality, performance, resemble",","),
                        "Printer",
                        "In computing, a printer is a peripheral which produces a text and/or graphics) of documents stored in electronic form, usually on physical print media such as paper or transparencies. The world's first computer printer was a 19th century mechanically driven apparatus invented by Charles Babbage for his Difference Engine. This system used a series of metal rods with characters printed on them and stuck a roll of paper against the rods to print the characters. The first commercial printers generally used mechanisms from electric typewriters and Teletype machines, which operated in a similar fashion. The demand for higher speed led to the development of new systems specifically for computer use.\n" +
                                "Personal computer printers can be distinguished as impact or non-impact printers. Early impact printers worked something like an automatic typewriter, with a key striking an inked impression on paper for each printed character . The dot-matrix printer was a popular low-cost personal computer printer. It's an impact printer that strikes the paper a line at a time. The best-known non-impact printers are the inkjet printer, of which several makes of low-cost color printers are an example, and the laser printer . The inkjet sprays ink from an ink cartridge at very close range to the paper as it rolls by. The laser printer uses a laser beam reflected from a mirror to attract ink (called toner ) to selected paper areas as a sheet rolls over a drum.\n" +
                                "Some printers, commonly known as network printers, have built-in network interfaces, typically wireless and/or Ethernet based, and can serve as a hard copy device for any user on the network. Individual printers are often designed to support both local and network connected users at the same time. In addition, a few modern printers can directly interface to electronic media such as memory cards, or to image capture devices such as digital cameras, scanners; some printers are combined with a scanners and/or fax machines in a single unit, and can function as photocopiers. Printers that include non-printing features are sometimes called multifunction printers (MFP), multi-function devices (MFD), or all-in-one (AIO) printers. Most MFPs include printing, scanning, and copying among their features.\n");
                exercises.add(exerciseUnderline7);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions7  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question7 = new ArrayList<>();
                question7.add("What kind of device is a printer?");
                question7.add("What can you tell about impact or non-impact printers? ");
                question7.add("How can network printers serve?");
                question7.add("What are individual printers often designed for?");
                question7.add("What kinds of printers are called multifunction printers?");
                exerciseAnswerQuestions7.setQuestions(question7);
                exercises.add(exerciseAnswerQuestions7);

                //3
                ExerciseWordsFillWrite exersiceWordsFillWrite1 = new ExerciseWordsFillWrite("III Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_GAP_EX);
                ArrayList<String> keywordss1 = new ArrayList<>();
                keywordss1.add("cartridge");
                keywordss1.add("double-sided");
                keywordss1.add("out of");
                keywordss1.add("reload");
                keywordss1.add("collate");
                keywordss1.add("mono");
                keywordss1.add("jammed");
                keywordss1.add("replacement");
                keywordss1.add("feed");
                keywordss1.add("out");
                keywordss1.add("print-heads");
                keywordss1.add("via");
                exersiceWordsFillWrite1.setWords(keywordss1);

                ArrayList<String> gapss1 = new ArrayList<>();
                gapss1.add("To ____________ means to put all the pages into the correct order.");
                gapss1.add("____________ cartridges can be ordered online.");
                gapss1.add("Can your printer do ____________ printing?");
                gapss1.add("The printer is ____________ paper. ____________ the paper tray.");
                gapss1.add("The printer is connected to the computer ____________ a USB cable.");
                gapss1.add("I think some paper is ____________ inside the printer.");
                gapss1.add("My printer keeps getting jammed. I think there's a problem with the paper ____________.");
                gapss1.add("\"Black and white\" is also known as ____________.");
                gapss1.add("Shall I print this ____________ in colour or black and white?");
                gapss1.add("If there's a problem with the print quality, perhaps the ____________ need cleaning.");
                gapss1.add("To change the cartridge, you have to lift the ____________.");
                gapss1.add("When the ink runs out, you have to change the ____________.");
                exersiceWordsFillWrite1.setGaps(gapss1);
                exercises.add(exersiceWordsFillWrite1);

                //4
                ExerciseTwoDefferientThink exerciseTwoDefferientThink = new ExerciseTwoDefferientThink("IV Exercise",
                        "Which type of printer is each sentence about?",
                        ExerciseTypes.TWO_DEFERENT_EX);
                ArrayList<String> wordsss1= new ArrayList<>();
                wordsss1.add("cheaper to buy");
                wordsss1.add("cheaper to run");
                wordsss1.add("faster printing speed");
                wordsss1.add("takes up more space");
                wordsss1.add("uses liquid ink");
                wordsss1.add("uses toner");
                wordsss1.add("more reliable");
                wordsss1.add("cartridges need changing more often");
                exerciseTwoDefferientThink.setWords(wordsss1);
                exerciseTwoDefferientThink.setFirstType("inkjet printer");
                exerciseTwoDefferientThink.setSeceondType("laser printer");
                exercises.add(exerciseTwoDefferientThink);

                //5
                ExerciseWordsFillWriteAudio exersiceWordsFillWrite12 = new ExerciseWordsFillWriteAudio("V Exercise",
                        "Fill in the blanks using the words from the right. Listen to the text and check up your answers.",
                        ExerciseTypes.FILL_TEXT_AUDIO_EX);
                ArrayList<String> keywordss223 = new ArrayList<>();
                keywordss223.add("Impact");
                keywordss223.add("color printing");
                keywordss223.add("non-impact");
                keywordss223.add("Dot-matrix printers");
                keywordss223.add("electro-static chemicals");
                keywordss223.add("ink-jet technologies");
                keywordss223.add("elaborate graphics");
                keywordss223.add("Laser printers");
                keywordss223.add("Ink-jet printers");
                exersiceWordsFillWrite12.setWords(keywordss223);
                exersiceWordsFillWrite12.setText("It is an important output device which can be used to get a printed copy of the processed text or result on paper. There are different types of printers that are designed for different types of applications. " +
                        "Depending on their speed and approach of printing, printers are classified as.........  or ...........printers. Impact printers use the familiar typewriter approach of hammering of a typeface against paper and inked ribbon. ............are of this type. Non-impact printers do not hit or impact a ribbon to print. They use ...........and............. . " +
                        "............and............ are of this type. This type of printers can produce........ and ..............");
                exersiceWordsFillWrite12.setAudioName("les8_5");
                exercises.add(exersiceWordsFillWrite12);

                //6
                ExerciseWriteSenrences exerciseWriteSenrences6 = new ExerciseWriteSenrences("VI Exercise",
                        "Write down about the usage of printer step by step.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips6 = new ArrayList<>();
                usefullTips6.add(".....external peripheral.......");
                usefullTips6.add("....be connected......");
                usefullTips6.add("...to make copies.......");
                usefullTips6.add("....held by........");
                usefullTips6.add("....print buffer......");
                exerciseWriteSenrences6.setUsefullTips(usefullTips6);
                exercises.add(exerciseWriteSenrences6);
                //7
                ExerciseTrueOrFalse exerciseTrueOrFalse = new ExerciseTrueOrFalse("VII Exercise",
                        "True or false?",
                        ExerciseTypes.TRUE_FALSE_EX);
                ArrayList<String> sentence = new ArrayList<>();
                sentence.add("\"ppm\" stands for pages per minute.");
                sentence.add("Color images are printed by mixing red, green and yellow ink.");
                sentence.add("Inkjet cartridges can be refilled up to three times");
                sentence.add("Most inkjet printers can print out at 100 ppm or more.");
                sentence.add("Recycled paper is made out of old bottles");
                sentence.add("Photo-paper is a lot more expensive than plain paper.");
                sentence.add("Inkjet cartridges are very difficult to change.");
                sentence.add("Before you can use a new printer, you have to install the driver from a CD-ROM.");
                sentence.add("Some Inkjet printers have three print qualities: draft, normal and best.");
                sentence.add("When a print job has started, it can't be cancelled.");
                exerciseTrueOrFalse.setSentence(sentence);
                exercises.add(exerciseTrueOrFalse);

                //8
                ExerciseSynonyms exerciseSynonyms8 = new ExerciseSynonyms("VIII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms9 = new ArrayList<>();
                synonyms9.add("a peripheral");
                synonyms9.add("physical print media");
                synonyms9.add("network printer");
                synonyms9.add("built-in network interface");
                synonyms9.add("image capture device");
                synonyms9.add("non-printing feature");
                synonyms9.add("multifunction printer");
                synonyms9.add("the on-demand convenience");
                synonyms9.add("project management");
                synonyms9.add("an out-sourced solution");
                exerciseSynonyms8.setWords(synonyms9);
                exercises.add(exerciseSynonyms8);

                //9
                ExerciseVocabulOwn exerciseVocabulOwn7 = new ExerciseVocabulOwn("IX Exercise",
                        "Put the text  “Printer”  into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn7.setPhotoName("les8_9");
                exercises.add(exerciseVocabulOwn7);
                break;
            case 8:
                //1
                ExerciseUnderline exerciseUnderline8 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("abbreviated, variation, to evolve, wands, reverse, application, impractical, drum, photomultiplier tube, resolution, attractive, disadvantage, distortion, reflection, shadow, advantage, portability, damaging, detection",","),
                        "SCANNER",
                        "A scanner is a device that captures images from photographic prints, posters, magazine pages, and similar sources for computer editing and display. Scanners come in hand-held, feed-in and flatbed types and for scanning black-and-white only, or color. Very high resolution scanners are used for scanning for high-resolution printing, but lower resolution scanners are adequate for capturing images for computer display. Scanners usually come with software, such as Adobe's Photoshop product, that lets you resize and otherwise modify a captured image.\n" +
                                "In computing, an image scanner—often abbreviated to just scanner— is a device that optically scans images, printed text, handwriting, or an object, and converts it to a digital image. Common examples found in offices are variations of the desktop (or flatbed) scanner where the document is placed on a glass window for scanning. Hand-held scanners, where the device is moved by hand, have evolved from text scanning \"wands\" to 3D scanners used for industrial design, reverse engineering, test and measurement, orthotics, gaming and other applications. Mechanically driven scanners that move the document are typically used for large-format documents, where a flatbed design would be impractical.\n" +
                                "Modern scanners typically use a charge-coupled device (CCD) or a Contact Image Sensor (CIS) as the image sensor, whereas older drum scanners use a photomultiplier tube as the image sensor. A rotary scanner, used for high-speed document scanning, is another type of drum scanner, using a CCD array instead of a photomultiplier. Other types of scanners are planetary scanners, which take photographs of books and documents, and 3D scanners, for producing three-dimensional models of objects.\n" +
                                "Another category of scanner is digital camera scanners, which are based on the concept of reprographic cameras. Due to increasing resolution and new features such as anti-shake, digital cameras have become an attractive alternative to regular scanners. While still having disadvantages compared to traditional scanners (such as distortion, reflections, shadows, low contrast), digital cameras offer advantages such as speed, portability and gentle digitizing of thick documents without damaging the book spine. New scanning technologies are combining 3D scanners with digital cameras to create full-color, photo-realistic 3D models of objects.\n" +
                                "In the biomedical research area, detection devices for DNA microarrays are called scanners as well. These scanners are high-resolution systems (up to 1 µm/ pixel), similar to microscopes. The detection is done via CCD or a photomultiplier tube.\n");
                exercises.add(exerciseUnderline8);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions8  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question8 = new ArrayList<>();
                question8.add("What kind of device is an image scanner?");
                question8.add("What do modern scanners typically use? ");
                question8.add("What are mechanically driven scanners used for?");
                question8.add("What disadvantages advantages do digital camera scanners have?");
                question8.add("What is DNA?");
                exerciseAnswerQuestions8.setQuestions(question8);
                exercises.add(exerciseAnswerQuestions8);

                //3
                ExerciseWordsFillWrite exersiceWordsFillWrite2 = new ExerciseWordsFillWrite("III Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_GAP_EX);
                ArrayList<String> keywordss23 = new ArrayList<>();
                keywordss23.add("adjust");
                keywordss23.add("brightness");
                keywordss23.add("flatbed");
                keywordss23.add("low");
                keywordss23.add("text");
                keywordss23.add("all-in-one");
                keywordss23.add("connected");
                keywordss23.add("handheld");
                keywordss23.add("OCR software");
                keywordss23.add("dpi");
                keywordss23.add("at");
                keywordss23.add("contrast");
                keywordss23.add("high");
                keywordss23.add("original");
                keywordss23.add("preview (or prescan)");
                keywordss23.add("file format");
                keywordss23.add("image editing");
                keywordss23.add("click");
                exersiceWordsFillWrite2.setWords(keywordss23);

                ArrayList<String> gapss2 = new ArrayList<>();
                gapss2.add("Make sure the scanner is _____________ to the computer.");
                gapss2.add("Lift the lid and put the _____________ on the scanner glass.");
                gapss2.add("For high image quality, scan ________ 300 _________ or higher.");
                gapss2.add("The scanning software will automatically do a _____________.");
                gapss2.add("If the image is too dark or too light, you can ______ the _______ and __________.");
                gapss2.add("_____________ \"scan\".");
                gapss2.add("If you scanned _____________, it can be \"read\" by __________.");
                gapss2.add("If you want to save the image, choose a _____________. JPEG is a good choice for photos.");
                gapss2.add("The scanned image can be manipulated using ________ software.");
                gapss2.add("An _____________ printer/scanner can print, scan and copy.");
                exersiceWordsFillWrite2.setGaps(gapss2);
                exercises.add(exersiceWordsFillWrite2);


                //4
                ExerciseTest exerciseTest3= new ExerciseTest("IV Exercise",
                        "Choose the best verb",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestions3 = new ArrayList<>();
                ArrayList<TestVariant> testVariants3 = new ArrayList<>();
                testQuestions3.add("When you connect this to your computer, it will work immediately. It's ____.");
                testVariants3.add(new TestVariant("plug and go","plug and play","plug and use"));
                testQuestions3.add("A call from New York to Tokyo is __________ distance.");
                testVariants3.add(new TestVariant("far","long","faraway"));
                testQuestions3.add("The screen on my laptop isn't very __________.");
                testVariants3.add(new TestVariant("light","white","bright"));
                testQuestions3.add("My video camera is very __________.");
                testVariants3.add(new TestVariant("easy to use","uncomplicated","obvious"));
                testQuestions3.add("My new computer has a very __________ processor.");
                testVariants3.add(new TestVariant("quick","high speed","fast"));
                testQuestions3.add("The X19 notebook computer features a very __________ design.");
                testVariants3.add(new TestVariant("compact","little","small"));
                testQuestions3.add("In three or four years, my new computer will probably be ______.");
                testVariants3.add(new TestVariant("old fashioned","behind the times","obsolete"));
                testQuestions3.add("Keeping files on a computer database is a __________ solution.");
                testVariants3.add(new TestVariant("new-tech","now-tech","high-tech"));
                testQuestions3.add("I don't think this printer is __________ with my computer.");
                testVariants3.add(new TestVariant("compatible","connectable","suitable"));
                testQuestions3.add("In our office, we've set up a __________ network.");
                testVariants3.add(new TestVariant("wire-free","no wires","wireless"));
                testQuestions3.add("I can't use my mobile phone. The battery's __________.");
                testVariants3.add(new TestVariant("over","flat","exhausted"));
                testQuestions3.add("My new PDA is the __________ model.");
                testVariants3.add(new TestVariant("latest","newest","most modern"));
                testQuestions3.add("My laptop is only 3 centimeters ___________.");
                testVariants3.add(new TestVariant("thick","tall","wide  "));
                testQuestions3.add("The battery isn't completely flat, but its very __________.");
                testVariants3.add(new TestVariant("down","short","low"));
                testQuestions3.add("Keeping files on paper is  __________ solution.");
                testVariants3.add(new TestVariant("an old-tech","a past-tech","a low-tech"));
                testQuestions3.add("Oh dear. I pressed the __________ button.");
                testVariants3.add(new TestVariant("incorrect","wrong","false"));
                exerciseTest3.setQuestions(testQuestions3);
                exerciseTest3.setTestVariants(testVariants3);
                exercises.add(exerciseTest3);

                //6
                ExerciseWriteSenrences exerciseWriteSenrences7 = new ExerciseWriteSenrences("VI Exercise",
                        "Write down about the usage of printer step by step.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips7 = new ArrayList<>();
                usefullTips7.add(".....optically scans images....");
                usefullTips7.add("...is placed on a glass window....");
                usefullTips7.add("....pass through the magnetic field.....");
                usefullTips7.add("....by using a beam of light, sound, or X-rays.");
                exerciseWriteSenrences7.setUsefullTips(usefullTips7);
                exercises.add(exerciseWriteSenrences7);

                //7
                ExerciseSynonyms exerciseSynonyms9 = new ExerciseSynonyms("VIII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms10 = new ArrayList<>();
                synonyms10.add("a digital image");
                synonyms10.add("variations of the desktop");
                synonyms10.add("a glass window");
                synonyms10.add("hand-held scanner");
                synonyms10.add("large-format document");
                synonyms10.add("a flatbed design");
                synonyms10.add("the image sensor ");
                synonyms10.add("photomultiplier tube ");
                synonyms10.add("high-speed document scanning");
                synonyms10.add("three-dimensional model");
                synonyms10.add("the concept of reprographic camera");
                synonyms10.add("portability and gentle digitizing ");
                synonyms10.add("the biomedical research area");
                synonyms10.add("high-resolution system");
                exerciseSynonyms9.setWords(synonyms10);
                exercises.add(exerciseSynonyms9);

                //8
                ExerciseVocabulOwn exerciseVocabulOwn8 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text  “SCANNER”  into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn8.setPhotoName("");
                exercises.add(exerciseVocabulOwn8);


                break;
            case 9:
                //1
                ExerciseUnderline exerciseUnderline9 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("volatile, RAM, , hard, permanent, backing, surface, to divide, track, sector, to insert, blank, to format, to record, location, entry, optical, WORMs, CD-ROMs, erasable, indelible, reason, to last, permanent, archiving, fields, , medicine, history, gigabyte",","),
                        "STORAGE DEVICES",
                        "A computer storage device is any type of hardware that stores data. The most common type of storage device, which nearly all computers have, is a hard drive. The computer's primary hard drive stores the operating system, applications, and files and folders for users of the computer.\n" +
                                "While the hard drive is the most ubiquitous of all storage devices, several other types are common as well. Flash memory devices, such as USB keychain drives and iPod nanos are popular ways to store data in a small, mobile format. Other types of flash memory, such as compact flash and SD cards are popular ways to store images taken by digital cameras.\n" +
                                "External hard drives that connect via Firewire and USB are also common. These types of drives are often used for backing up internal hard drives, storing video or photo libraries, or for simply adding extra storage. Finally, tape drives, which use reels of tape to store data, are another type of storage device and are typically used for backing up data.\n" +
                                "A data storage device is a device for recording (sto-ring) information (data). Recording can be done using virtually any form of energy, spanning from manual muscle power in handwriting, to acoustic vibrations in phonographic recording, to electromagnetic energy modulating magnetic and optical discs.\n" +
                                "A storage device may hold information, process information, or both. A device that only holds information is a recording me-dium. Devices that process information (data storage equipment) may either access a separate portable (removable) recording medium or a permanent component to store and retrieve information.\n" +
                                "Electronic data storage requires electrical power to store and retrieve that data. Most storage devices that do not require vi-sion and a brain to read data fall into this category. Electromagnetic data may be stored in either an analog data or digital data format on a variety of media. This type of data is considered to be electronically encoded data, whether or not it is electronically stored in a semiconductor device, for it is certain that a semiconductor device was used to record it on its medium.\n");

                exercises.add(exerciseUnderline9);


                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions9  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question9 = new ArrayList<>();
                question9.add("What is a computer storage device is?");
                question9.add("What kind of computer storage devices do you know? ");
                question9.add("What is a data storage device?");
                question9.add("What is electronic data storage?");
                question9.add("What may electromagnetic data be stored in?");
                exerciseAnswerQuestions9.setQuestions(question9);
                exercises.add(exerciseAnswerQuestions9);

                //3
                ExerciseWordsFillWrite exersiceWordsFillWrite3 = new ExerciseWordsFillWrite("III Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_GAP_EX);
                ArrayList<String> keywordss3 = new ArrayList<>();
                keywordss3.add("burn");
                keywordss3.add("eject");
                keywordss3.add("capacity");
                keywordss3.add("free space");
                keywordss3.add("card");
                keywordss3.add("hard drive");
                keywordss3.add("drawer");
                keywordss3.add("stick");
                exersiceWordsFillWrite3.setWords(keywordss3);

                ArrayList<String> gapss3 = new ArrayList<>();
                gapss3.add("Digital cameras usually store pictures on a memory _____ or a memory ____.");
                gapss3.add("To run this application you need at least 50MB of _______ on your hard drive. ");
                gapss3.add("My computer's hard drive has a _______________ of 120GB.");
                gapss3.add("I can't eject the CD. I think the _______'s stuck. ");
                gapss3.add("The opposite of \"Insert the DVD\" is \"_______________ the DVD\".");
                gapss3.add("Do you like this CD? I can _______ you a copy if you want.");
                gapss3.add("The data and applications on your computer are stored on the _________.");
                exersiceWordsFillWrite3.setGaps(gapss3);
                exercises.add(exersiceWordsFillWrite3);

                //3
                ExerciseWordsFillWrite exersiceWordsFillWrite33 = new ExerciseWordsFillWrite("III Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_GAP_EX);
                ArrayList<String> keywordss2233 = new ArrayList<>();
                keywordss2233.add("burn");
                keywordss2233.add("eject");
                keywordss2233.add("capacity");
                keywordss2233.add("free space");
                keywordss2233.add("card");
                keywordss2233.add("hard drive");
                keywordss2233.add("drawer");
                keywordss2233.add("stick");
                exersiceWordsFillWrite33.setWords(keywordss2233);

                ArrayList<String> gapss44 = new ArrayList<>();
                gapss44.add("Digital cameras usually store pictures on a memory _____ or a memory ____.");
                gapss44.add("To run this application you need at least 50MB of _______ on your hard drive.");
                gapss44.add("My computer's hard drive has a _______________ of 120GB. ");
                gapss44.add("I can't eject the CD. I think the _______'s stuck. ");
                gapss44.add("The opposite of \"Insert the DVD\" is \"_______________ the DVD\".");
                gapss44.add("Do you like this CD? I can _______ you a copy if you want.");
                gapss44.add("The data and applications on your computer are stored on the _________");
                exersiceWordsFillWrite33.setGaps(gapss44);
                exercises.add(exersiceWordsFillWrite33);


                //4
                ExerciseTest exerciseTest4= new ExerciseTest("IV Exercise",
                        "Choose the correct letter a, b, c",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestions4 = new ArrayList<>();
                ArrayList<TestVariant> testVariants4 = new ArrayList<>();
                testQuestions4.add("This wire's too short. I need an __________ cable.");
                testVariants4.add(new TestVariant("extended","extension","extender"));
                testQuestions4.add("You can connect a USB plug to a PS/2 port by using __________.");
                testVariants4.add(new TestVariant("an adaptor","a bridge","a connector"));
                testQuestions4.add("I want to get a __________ ADSL modem.");
                testVariants4.add(new TestVariant("quick-speed","fast-speed","high-speed"));
                testQuestions4.add("ADSL is also known as __________.");
                testVariants4.add(new TestVariant("wideband","broadband","long band"));
                testQuestions4.add("… with a USB __________.");
                testVariants4.add(new TestVariant("centre","point","hub"));
                testQuestions4.add("The internet is much faster with a broadband connection than with __________.");
                testVariants4.add(new TestVariant("dial-up","phone-up","call-up"));
                testQuestions4.add("With a wireless router, you can __________ your broadband connection with other users.");
                testVariants4.add(new TestVariant("divide","combine","share"));
                testQuestions4.add("Scanners, printers and webcams are __________.");
                testVariants4.add(new TestVariant("extras","peripherals","externals"));
                testQuestions4.add("Add extra USB __________ to your computer….");
                testVariants4.add(new TestVariant("ports","doors","windows"));
                exerciseTest4.setQuestions(testQuestions4);
                exerciseTest4.setTestVariants(testVariants4);
                exercises.add(exerciseTest4);

                //5
                ExerciseFillTextWords exerciseFillTextWords2 = new ExerciseFillTextWords("V Exercise",
                        "Complete the gaps in the text below using the words from the box.",
                        ExerciseTypes.FILL_TEXT_WITH_WORDS_EX);
                exerciseFillTextWords2.setText("Bluetooth _____ devices use short-range radio ______ to exchange _____ quickly and easily. Bluetooth technology enables ______ communication between _____ such as laptop computers, mobile phones and PDAs. The technology was ______ by a group of computer and ______ companies including IBM, Intel, Nokia and Ericsson.");
                ArrayList<String> wordsss2 = new ArrayList<>();
                wordsss2.add("Data");
                wordsss2.add("signals");
                wordsss2.add("developed");
                wordsss2.add("wireless");
                wordsss2.add("devices");
                wordsss2.add("telecommunications");
                wordsss2.add("enabled");
                exerciseFillTextWords2.setWords(wordsss2);
                exercises.add(exerciseFillTextWords2);
                //6
                ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswers4 = new ExerciseListenCheckUpAnswers("VI Exercise",
                        "Listen and check up your answers.",ExerciseTypes.LISTENING_ANSWER_KEY, "les10_5");
                exercises.add(exerciseListenCheckUpAnswers4);

                //7
                ExerciseWriteSenrences exerciseWriteSenrences8 = new ExerciseWriteSenrences("VII Exercise",
                        "Listen to the text again and write down summary.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips78 = new ArrayList<>();
                usefullTips78.add("…. is commonly understood.......");
                usefullTips78.add("….holds information….");
                usefullTips78.add("……is/are also mentioned in the following  text.");
                usefullTips78.add("….do not require…");
                exerciseWriteSenrences8.setUsefullTips(usefullTips78);
                exercises.add(exerciseWriteSenrences8);

                //8
                ExerciseSynonyms exerciseSynonyms10 = new ExerciseSynonyms("VIII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms11 = new ArrayList<>();
                synonyms11.add("Volatile");
                synonyms11.add("to turn off");
                synonyms11.add("permanent");
                synonyms11.add("surface");
                synonyms11.add("to divide ");
                synonyms11.add("track");
                synonyms11.add("sector");
                synonyms11.add("to insert");
                synonyms11.add("blank");
                synonyms11.add("to format");
                synonyms11.add("to record");
                synonyms11.add("indelible");
                exerciseSynonyms10.setWords(synonyms11);
                exercises.add(exerciseSynonyms10);

                //9
                ExerciseVocabulOwn exerciseVocabulOwn9 = new ExerciseVocabulOwn("IX Exercise",
                        "Put the text “STORAGE DIVICES”  into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn9.setPhotoName("");
                exercises.add(exerciseVocabulOwn9);

                break;
            case 10:
                //1
                ExerciseUnderline exerciseUnderline10 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("microprocessor, arithmetic, to associate, circuitry, , silicon, chip, transistor, resistor, to measure, string, binary, digits, cathode, ray, dimensional plotter, buffers, to interpret, accumulator, centi-meter, to perform",","),
                        "MICROPROCESSOR",
                        "A microprocessor incorporates the functions of a computer's central processing unit (CPU) on a single integrated circuit (IC), or at most a few integrated circuits. All modern CPUs are micro-processors making the micro- prefix redundant. The microprocessor is a multipurpose, programmable device that accepts digital data as input, processes it according to instructions stored in its memory, and provides results as output. \n" +
                                "The microprocessor is the heart of any normal computer, whether it is a desktop machine, a server or a laptop. The micro-processor you are using might be a Pentium, a K6, a PowerPC, a Sparc or any of the many other brands and types of microprocessors, but they all do approximately the same thing in approximately the same way.\n" +
                                "A microprocessor -also known as a CPU or central processing unit - is a complete computation engine that is fabricated on a single chip. The first microprocessor was the Intel 4004, introduced in 1971. The 4004 was not very powerful -- all it could do was add and subtract, and it could only do that 4 bits at a time. But it was amazing that everything was on one chip. Prior to the 4004, engineers built computers either from collections of chips or from discrete components (transistors wired one at a time). The 4004 powered one of the first portable electronic calculators.\n" +
                                "A microprocessor is the central arithmetic and logic unit of a computer, together with its associated circuitry, scaled down so that it fits on a single silicon chip (sometimes several chips) holding tens of thousands of transistors, resistors and similar circuit element. A typical microprocessor chip measures half a centimeter on a side. The task of the microprocessor is to receive data in the form of strings of binary digits (0’s and 1’s). A typical microprocessor consist sof the following units: a decode and control unit (to interpret instructions from the stored program), the arithmetic and logic unit, or ALU (to perform arithmetic and logic operations), registers (to serve as an easily accessible memory for data which are frequently manipulated), an accumulator (a special register closely associated with the ALU), address buffers (to supply the control memory with the address from which to take the next instruction) and input/output buffers (to read instructions or data into the microprocessor or to send them out).\n");

                exercises.add(exerciseUnderline10);


                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions10  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question10 = new ArrayList<>();
                question10.add("What kind of unit is a microprocessor?");
                question10.add("What is the task of the microprocessor? ");
                question10.add("What is microprocessor for computer?");
                question10.add("What are the units of the typical microprocessor?");
                question10.add("What kind of buffers do you know?");
                exerciseAnswerQuestions10.setQuestions(question10);
                exercises.add(exerciseAnswerQuestions10);


                //3
                ExerciseTest4x exerciseTest4x= new ExerciseTest4x("III Exercise",
                        "Choose the right answer",
                        ExerciseTypes.TEST_EX);
                ArrayList<String> testQuestionss3 = new ArrayList<>();
                ArrayList<TestVariant4x> testVariants5 = new ArrayList<>();
                testQuestionss3.add("Which of the following is an operating system you would be using on the computer?");
                testVariants5.add(new TestVariant4x("Internet Explorer","Microsoft Windows","Netscape","Microsoft Word"));
                testQuestionss3.add("Which of these is a not a computer manufacturer?");
                testVariants5.add(new TestVariant4x("IBM","Apple","Sun","Microsoft"));
                testQuestionss3.add("What does RAM stand for?");
                testVariants5.add(new TestVariant4x("Random Access Memory","Remote Authorization Mechanism","Readily Accessed Mailer","Random Authorization Mechanism"));
                testQuestionss3.add("DOS stands for");
                testVariants5.add(new TestVariant4x("Dual Operating System","Disk Operating System","Dual Organized System","Disk Organized System"));
                testQuestionss3.add("Physical components that make up your computer are known as:");
                testVariants5.add(new TestVariant4x("Hardware","Software","Operating Systems","Web Browsers"));
                testQuestionss3.add("Which of the following companies is famous for manufacturing computer processors?");
                testVariants5.add(new TestVariant4x("Sony","Macromedia","Corel","Intel"));
                testQuestionss3.add("Which of the following will you require to hear music on your computer?");
                testVariants5.add(new TestVariant4x("Video Card","Sound Card","Mouse","Joy Stick"));

                exerciseTest4x.setQuestions(testQuestionss3);
                exerciseTest4x.setTestVariants(testVariants5);
                exercises.add(exerciseTest4x);

                //4
                ExerciseWordsFillWriteAudio exersiceWordsFillWrite111 = new ExerciseWordsFillWriteAudio("IV Exercise",
                        "Fill in the blanks using the words and word combinations which are given in the box. Listen to the text and check up your answers.",
                        ExerciseTypes.FILL_TEXT_AUDIO_EX);
                ArrayList<String> keywordss222 = new ArrayList<>();
                keywordss222.add("device/equipment");
                keywordss222.add("check/control");
                keywordss222.add("decode/interpret");
                keywordss222.add("computers /microcomputers");
                keywordss222.add("mechanical/ automatic");
                keywordss222.add("automobiles/cars");
                exersiceWordsFillWrite111.setWords(keywordss222);
                exersiceWordsFillWrite111.setText("Miniature electronic ....... that con-tains the arithmetic, logic, and ……. circuitry needed to function as a digital computer's CPU. Micro-processors are integrated circuits that can ……. and execute program instructions as well as handle arithmetic operations. Their development in the late 1970s enabled computer engineers to develop…….. Microprocessors led to “intelligent” terminals, such as bank ATMs and point-of-sale devices, and to……. control of much industrial instrumentation and hospital equipment, programmable microwave oven and electronic games. Many …….use microprocessor-controlled ignition and fuel systems.");
                exersiceWordsFillWrite111.setAudioName("les10_4");
                exercises.add(exersiceWordsFillWrite111);

                //5
                ExerciseWriteSenrences exerciseWriteSenrences9 = new ExerciseWriteSenrences("VII Exercise",
                        "Listen to the text again and write down summary.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                ArrayList<String> usefullTips79 = new ArrayList<>();
                usefullTips79.add("This has been seen ……");
                usefullTips79.add("……..makes it clear that..");
                usefullTips79.add("…..in this text");
                usefullTips79.add("...there is an obvious link between....");
                usefullTips79.add("...is/are pointed out.....");
                exerciseWriteSenrences9.setUsefullTips(usefullTips79);
                exercises.add(exerciseWriteSenrences9);

                //6
                ExerciseMatchWords exerciseMatchWords2 = new ExerciseMatchWords("IV Exercise",
                        "Match the words",
                        ExerciseTypes.MATCH_WORDS_EX);
                ArrayList<String> firstCol2 = new ArrayList<>();
                firstCol2.add("I want to make a copy of a music CD.");
                firstCol2.add("I want to store some files. I may need to update them in the future.");
                firstCol2.add("I want to back up data from my computer. I want to update it every day.");
                firstCol2.add("My computer's having  problems with reading and writing CDs.");
                firstCol2.add("I want to add 100MB of extra storage to my computer.");
                firstCol2.add("I want to send a copy of a small file to a friend. He has an old computer.");
                firstCol2.add("My computer’s running slowly.");
                exerciseMatchWords2.setFirstCollumb(firstCol2);
                ArrayList<String> secondCol2 = new ArrayList<>();
                secondCol2.add("You need an external hard drive.");
                secondCol2.add("Use a CD-R.");
                secondCol2.add("Try a USB flash drive.");
                secondCol2.add("Perhaps you need a new internal CD drive");
                secondCol2.add("Put them on a CD-RW.");
                secondCol2.add("Perhaps you need to defragment the hard drive.");
                secondCol2.add("You could put it on a floppy disk.");
                exerciseMatchWords2.setFirstCollumb(secondCol2);
                exercises.add(exerciseMatchWords2);

                //7
                ExerciseSynonyms exerciseSynonyms11 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms12 = new ArrayList<>();
                synonyms12.add("microprocessor");
                synonyms12.add("arithmetic");
                synonyms12.add("to associate");
                synonyms12.add("circuitry");
                synonyms12.add("scale down");
                synonyms12.add("chip");
                synonyms12.add("transistor");
                synonyms12.add("resistor");
                synonyms12.add("to measure");
                synonyms12.add("ray");
                synonyms12.add("dimensional plotter");
                synonyms12.add("buffers");
                exerciseSynonyms11.setWords(synonyms12);
                exercises.add(exerciseSynonyms11);

                //8
                ExerciseVocabulOwn exerciseVocabulOwn10 = new ExerciseVocabulOwn("IX Exercise",
                        "Put the text “MICROPROCESSOR” into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn10.setPhotoName("");
                exercises.add(exerciseVocabulOwn10);

                break;
            case 11:
                //1
                ExerciseUnderline exerciseUnderline11 = new ExerciseUnderline(
                        "I Exercise","Scan the text below and underline these words and word combinations.",
                        ExerciseTypes.UNDERLINE_EX,
                        StringUtils.spillter("a carrier, baud, demodulate, digital information, familiar,                                                   frequency, shift keying, incidental, measured, modulate, multip-lexing, receiver,  the definition,  the goal, to recover, to reproduce, to transmit",","),
                        "Modem",
                        "A modem (modulator-demodulator) is a device that modulates an analog carrier signal to encode digital information, and also demodulates such a carrier signal to decode the transmitted information. The goal is to produce a signal that can be transmitted easily and decoded to reproduce the original digital data. Modems can be used over any means of transmitting analog signals, from driven diodes to radio.\n" +
                                "The most familiar example is a voice band modem that turns the digital data of a personal computer into modulated electrical signals in the voice frequency range of a telephone channel. These signals can be transmitted over telephone lines and demodulated by another modem at the receiver side to recover the digital data.\n" +
                                "Modems are generally classified by the amount of data they can send in a given time unit, normally measured in bits per second (bit/s, or bps). They can also be classified by the symbol rate measured in baud, the number of times the modem changes its signal state per second. For example, the ITU V.21 standard used audio frequency-shift keying, aka tones, to carry 300 bit/s using 300 baud, whereas the original ITU V.22 standard allowed 1,200 bit/s with 600 baud using phase shift keying. \n" +
                                "News wire services in 1920s used multiplex equipment that met the definition, but the modem function was incidental to the multiplexing function, so they are not commonly included in the history of modems.\n");

                exercises.add(exerciseUnderline11);

                //2
                ExerciseAnswerQuestions exerciseAnswerQuestions11  = new ExerciseAnswerQuestions("II Exercise","Read the text again and answer the questions", ExerciseTypes.QUESTION_EX);
                ArrayList<String> question11 = new ArrayList<>();
                question11.add("What kind of device is a modem?");
                question11.add("What is the goal of decoding the transmitted information? ");
                question11.add("What can modems be used for?");
                question11.add("How can demodulated signals be transmitted?");
                question11.add("How are modems generally classified by?");
                exerciseAnswerQuestions11.setQuestions(question11);
                exercises.add(exerciseAnswerQuestions11);

                //3
                ExercisePickPic exersicePickPicc3 = new ExercisePickPic("III Exercise",
                        "Match the words and the word combination with the picture",
                        ExerciseTypes.PIC_PICK_EX );
                exersicePickPicc3.setPhotoName("les12_3");
                ArrayList<String> wordss3 = new ArrayList<>();
                wordss3.add("Standby");
                wordss3.add("Power");
                wordss3.add("Receive");
                wordss3.add("Ethernet");
                wordss3.add("Button");
                wordss3.add("Activity");
                wordss3.add("Coax");
                wordss3.add("OnlinePower");
                wordss3.add("USB");
                wordss3.add("Send");
                exersicePickPicc3.setWords(wordss3);
                exercises.add(exersicePickPicc3);

                //4
                ExerciseJumpled exerciseJumpled22 = new ExerciseJumpled("IV Exercise",
                        "Put the jumbled part of the sentences in the right order.",
                        ExerciseTypes.JUMPED_KEY);
                ArrayList<String> jumpleds12= new ArrayList<>();
                jumpleds12.add("of, analog, can, over, Modems, signals, be, used, any, means, transmitting,");
                jumpleds12.add("by, can, demodulated, Signals, over, telephone, lines, and, be, another, transmitted,");
                jumpleds12.add("decoding, transmitted, What, is, goal, of, the, information, the,?");
                jumpleds12.add("by, classified, band, Modems, also, be, the, rate, measured, in, can, symbol,");
                jumpleds12.add("the, SW0,To, must, the, modem, you, reset, by, pressing, operate, modem,");
                exerciseJumpled22.setJumpleds(jumpleds12);
                exercises.add(exerciseJumpled22);

                //5
                ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswersss = new ExerciseListenCheckUpAnswers("V Exercise",
                        "Listen and check up your answers.",ExerciseTypes.LISTENING_ANSWER_KEY, "les12_5");
                exercises.add(exerciseListenCheckUpAnswersss);

                //6
                ExerciseWriteSentencesText exerciseWriteSenrences32 = new ExerciseWriteSentencesText("VI Exercise",
                        "Read the text and write a summary.",
                        ExerciseTypes.WRITE_SENTENCES_EX);
                exerciseWriteSenrences32.setText("A Wireless Access Point (WAP) is a device that connects to a wired network and creates a wireless network that can access the wired network. A wireless router will contain a WAP - think of a WAP as the radio portion of a wireless router broken out into a separate device. \n" +
                        "You would use a WAP if you have a wired network and want to add one or more wireless clients. These wireless clients may be too far away from your existing cabling. \n" +
                        "WAPs are not as popular as they once were. Wireless routers have dropped in price so much that it can be more economical to replace a wired router with a wireless router and use the wireless router's wired ports to handle the wired portion of the network.\n");
                ArrayList<String> usefullTips32 = new ArrayList<>();
                usefullTips32.add("....is shown ...in this text.");
                usefullTips32.add("For instance,.......");
                usefullTips32.add("...makes it clear that....");
                usefullTips32.add("From .... it can be concluded...");
                exerciseWriteSenrences32.setUsefullTips(usefullTips32);
                exercises.add(exerciseWriteSenrences32);

                //7
                ExerciseSynonyms exerciseSynonyms112 = new ExerciseSynonyms("VII Exercise",
                        "Give the definition or try to find the synonyms of the following words and word combinations",
                        ExerciseTypes.SYNONYMS_EX);
                ArrayList<String> synonyms122 = new ArrayList<>();
                synonyms122.add("a voice band modem");
                synonyms122.add("an analog carrier signal");
                synonyms122.add("bits per second");
                synonyms122.add("digital information");
                synonyms122.add("means of transmitting");
                synonyms122.add("phase shift keying");
                synonyms122.add("the amount of data");
                synonyms122.add("the multiplexing function");
                synonyms122.add("the symbol rate");
                synonyms122.add("the voice frequency range");
                exerciseSynonyms112.setWords(synonyms122);
                exercises.add(exerciseSynonyms112);


                //8
                ExerciseVocabulOwn exerciseVocabulOwn11 = new ExerciseVocabulOwn("VIII Exercise",
                        "Put the text “Modem” into your own words using vocabulary.",
                        ExerciseTypes.VOC_OWN_EX);
                exerciseVocabulOwn11.setPhotoName("");
                exercises.add(exerciseVocabulOwn11);

                break;

        }



    return exercises;

    }
}
