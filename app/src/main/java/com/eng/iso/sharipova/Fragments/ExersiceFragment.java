package com.eng.iso.sharipova.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.iso.sharipova.Adapters.ExersiceListAdapter;
import com.eng.iso.sharipova.Adapters.LessonListAdapter;
import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseUnderline;
import com.eng.iso.sharipova.Entity.Lesson;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExersiceTypes;
import com.eng.iso.sharipova.Utils.StringUtils;

import java.util.ArrayList;


public class ExersiceFragment extends Fragment {
    ArrayList<Exercise> exercises;
    RecyclerView rvExercises;
    int lessonNumber = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_exersice, container, false);
        if(getArguments()!=null){
            lessonNumber = getArguments().getInt(ExersiceTypes.EXERSICE_TYPE);
        }
        fillData();
        rvExercises = (RecyclerView) inflate.findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvExercises.setLayoutManager(linearLayoutManager);
        ExersiceListAdapter exersiceListAdapter = new ExersiceListAdapter(exercises,getActivity());
        rvExercises.setAdapter(exersiceListAdapter);
        return inflate;
    }

    public void fillData(){
        exercises = new ArrayList<>();

        switch (lessonNumber){
            case 0:
                ExerciseUnderline exerciseUnderline = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("electronic machines, to accept, data, to process, to feed, memory, to calculate, screen, to perform,  output, capable, storing, to print, device, program,  to serve, logical, operations, forecast, , to solve,  to contain, capacity",","),
                        "COMPUTERS",
                        "A computer is a general purpose device that can be programmed to carry out a set of arithmetic or logical operations automatically. Since a sequence of operations can be readily changed, the computer can solve more than one kind of problem. The word computer comes from a Latin word which means to count. Computers are electronic machines which can accept data in a certain form, process data and give the results of the processing. There are three basic steps in the process: first, you feed data into the computer’s memory. Then, the computer performs a set of instructions and processes the data. Finally, you can see the results (the output) on the screen or in the printed form. The machine is capable of storing and manipulating numbers, letters, and characters. Computers for personal use come in all shapes and sizes, from tiny smart phones to PC (personal computer) towers.\n" +
                        "There are different types of Computer: 1.Micro Computer is self contained units and usually designed to use by one person at a time. 2.Mini Computer is usually designed to serve many users simultaneously, it is a medium size computer. 3.Mainframe Computer with large storage capacities and very high speed of processing as compared to micro or minicomputers. 4.Super Computers have extremely large storage capacity and computing speed which is at least 10 times faster than others.\n" +
                        "However, the word Computer originates from the word compute that means to calculate, now a day’s amazingly 80% + of work is done in computers even of non numerical nature like music composing, special effects, resume sorting, forecasting, nuclear research etc. Computer not only processes the data and makes you available the information but also able to perform the subsequent steps on the basis of processed information that’s why computer even something more than a data processing device.\n");

                exercises.add(exerciseUnderline);

                break;
            case 1:

                ExerciseUnderline exerciseUnderline1 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("computer system, components, purpose,  to solve, hardware, software, machinery, functions,  manuals, listings, to require, items, typewriter, user, storage, central unit, Arithmetic Logic Unit, to decode, sequence, calculations, manipulation",","),
                        "COMPUTER SYSTEM",
                        "A computer system is one that is able to take a set of inputs, process them and create a set of outputs. This is done by a combination of hardware and software. The purpose of a computer system is to make it as easy as possible for you to use a computer to solve problems. The hardware elements are the mechanical devices in the system, the machinery and the electronics that perform physical functions. The software elements are the programs written for the system; these programs perform logical and mathematical operations and provide a means for you to control the system. Documentation includes the manuals and listings that tell you how to use the hardware and software. Collectively these components provide a complete computer system: system hardware + system software + system documentation = computer system. Usually, a computer system requires these basic hardware items: the computer, which performs all data processing; a terminal device, used like a typewriter for two-way communication between the user and the system; and a storage medium for storing programs and data.\n" +
                                "The computer system has one or more inputs to provide data. This data is then processed in some way. The outcome of the processing is sent to an output or it may be stored until some event happens to cause it to be output. \n" +
                                "For processing to take place, there needs to be a set of instructions of what needs to be done. This set of instruction is called a program. This system is called a stored program computer.\n" +
                                "The central processor has two main parts. They are the Control Unit (CU) and the Arithmetic Logic Unit (ALU).   The CU controls all the other units in the computer system. It decodes the program instructions and makes sure they are carried out in the correct sequence.  The ALU, on the other hand, performs the calculations and data manipulation, for example comparing, sorting and combining data.\n");

                exercises.add(exerciseUnderline1);

                break;
            case 2:
                ExerciseUnderline exerciseUnderline2 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("to press, an arrangement, mechanical levers, electronic switches, derive, layout, typewriter, to enter, edit, to depend on, frequently, to attach, shut down, appearance, additional, to bring up",","),
                        "Keyboard",
                        "A computer keyboard is an input device used to enter characters and functions into the computer system by pressing buttons, or keys. It is the primary device used to enter text. In computing, a keyboard is a typewriter keyboard, which uses an arrangement of buttons or keys, to act as mechanical levers or electronic switches. Most keyboards have a very similar layout. The individual keys for letters, numbers and special characters are collectively called the character keys. The layout of these keys is derived from the original layout of keys on a typewriter. The most widely used layout in the English language is called QWERTY, named after the sequence of the first six letters from the top left. Other sets of keys common to almost all keyboards are entering and editing keys (e.g., Enter, Delete, Insert), modifier keys (e.g., Control, Shift), navigation keys (e.g., arrows for up, down, left, right) and lock keys (e.g., Caps Lock). Additional keys are very operating system specific (such as the Windows and Apple keys). Most keyboards also include a set of function keys at the top (F1, F2, etc.). The function keys typically perform a very specific task within a particular software application. So, what they do may depend on what you are doing on your computer at the time. A keyboard is also used to give commands to the operating system of a computer, such as Windows' Control-Alt-Delete combination, which brings up a task window or shuts down the machine. It is the only way to enter commands on a command-line interface. Keyboards vary in appearance. Those attached to a desktop computer are frequently large with an additional number pad built in on the right side, while laptop keyboards are attached to the computer and are often much smaller. Some keyboards also offer special buttons to control the mouse on the screen or to play music.");

                exercises.add(exerciseUnderline2);
                break;
            case 3:
                ExerciseUnderline exerciseUnderline3 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("a scroll wheel, a pointing device, the cursor, feature, a button, motion, interface, two-dimensional, a surface, spring-loaded, lightly, to Click, bound, a text file, to hover",","),
                        "Mouse",
                        "What makes the mouse especially useful is that it is a very quick way to move around on a screen. The mouse also issues instructions to the computer very quickly. Point to an available option with the cursor, click on the mouse, and the option has been chosen. A computer mouse has the most common standard features: two buttons and a scroll wheel, which can also act as a third button. In computing, a mouse is a pointing device that functions by detecting two-dimensional motion relative to its supporting surface. Physically, a mouse consists of an object held under one of the user's hands, with one or more buttons. (Although traditionally a button is typically round or square, modern mice have spring-loaded regions of their top surface that operate switches when pressed down lightly.) It sometimes features other elements, such as \"wheels\", which allow the user to perform various system-dependent operations, or extra buttons or features that can add more control or dimensional input. The mouse's motion typically translates into the motion of a cursor on a display, which allows for fine control of a graphical user interface.\n" +
                                "Different ways of operating the mouse typically controls the motion of a cursor in two dimensions in a graphical user interface (GUI). Clicking or hovering (stopping movement while the cursor is within the bounds of an area) can select files, programs or actions from a list of names, or (in graphical interfaces) through small images called \"icons\" and other elements. For example, a text file might be represented by a picture of a paper notebook, and clicking while the cursor hovers this icon might cause a text editing program to open the file in a window.\n");

                exercises.add(exerciseUnderline3);
                break;
            case 4:
                ExerciseUnderline exerciseUnderline4 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("the enclosure, to contain, floppy drive, power supply,  to construct, consequently, specific, the internal dimensions, layout, rack-mounted, blade server, external, card reader,size,  shape",","),
                        "A computer case",
                        "A computer case (also known as a computer chassis, cabinet, box, tower, enclosure, housing, system unit or simply case) is the enclosure that contains most of the components of a computer Everything including the motherboard, the hard drive, the cd drive, the floppy drive and the power supply go inside a computer case.\n" +
                                "Computer desktop cases generally have trays for the CD/DVD drives, floppy drives and hard drives. There is also a place for the power supply and the on-switch cables which usually come with the case. These are connected with the buttons at the front and these connect to pins on the motherboard. Cases are usually constructed from steel (often SECC—Steel, Electrically Chromate Coated) or aluminum. Plastic is sometimes used, and other materials such as wood and even Lego blocks have appeared in home-built cases. \n" +
                                "Cases can come in many different sizes (known as form factors). The size and shape of a computer case is usually determined by the form factor of the motherboard, since it is the largest component of most computers. Consequently, personal computer form factors typically specify only the internal dimensions and layout of the case. Form factors for rack-mounted and blade servers may include precise external dimensions as well, since these cases must themselves fit in specific enclosures. A few years ago, desktop computer cases were just plain. However, today for a little bit more money you can get computers with cool designs and colors. Some computer cases now come with front USB (Universal Serial Bus) and some even have a card reader, firewire or ports for a headset. \n");

                exercises.add(exerciseUnderline4);
                break;
            case 5:
                ExerciseUnderline exerciseUnderline5 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
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
                break;
            case 6:
                ExerciseUnderline exerciseUnderline6 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("video adapter, graphics accelerator, an expansion card, to generate, an offer, added functions, rendering, to capture, TV-tuner adapter, to occur, to include, flat screen, fan/heatsink combinations, graphics card, processing, to generate, niche",","),
                        "A video card",
                        "A video card connects to the motherboard of a computer system and generates output images to display. Video cards are also referred to as graphics cards. Video cards include a processing unit, memory, a cooling mechanism and connections to a display device.\n" +
                                "A video card, video adapter, graphics accelerator card, display adapter, or graphics card is an expansion card whose function is to generate output images to a display. Many video cards offer added functions, such as accelerated rendering of 3D scenes and 2D grap¬hics, video capture, TV-tuner adapter, MPEG-2/MPEG-4 decoding, FireWire, light pen, TV output, or the ability to connect multiple mo¬nitors (multi-monitor). Other modern high performance video cards are used for more graphically demanding purposes, such as PC games.\n" +
                                "Video hardware can be integrated on the motherboard, often occurring with early machines. In this configuration it is sometimes referred to as a video controller or graphics controller. Video cards usually come with at least a couple of different types of ports for connecting display devices.  The most common ones today are standard VGA (found on nearly every monitor), HDMI (high definition multimedia interface) and DVI (digital visual interface) which are the predominant protocols in mid to higher end monitors and flat screen tvs.  S-Video can also be found on some niche specific cards.\n" +
                                "The final component is the heatsink/fan.  All video cards will some type of heatsink attached to them to reduce the chances of the GPU overheating.  Higher end video cards will have larger heatsinks or even fan/heatsink combinations as they tend to generate more heat or are installed in higher end computers that also tend to generate more heat.\n");

                exercises.add(exerciseUnderline6);
                break;
            case 7:
                ExerciseUnderline exerciseUnderline7 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("peripheral, attached, wireless, to support, feature, consumer, virtually, to achieve, inexpensive, relatively, offset, convenience, quality, performance, resemble",","),
                        "Printer",
                        "In computing, a printer is a peripheral which produces a text and/or graphics) of documents stored in electronic form, usually on physical print media such as paper or transparencies. The world's first computer printer was a 19th century mechanically driven apparatus invented by Charles Babbage for his Difference Engine. This system used a series of metal rods with characters printed on them and stuck a roll of paper against the rods to print the characters. The first commercial printers generally used mechanisms from electric typewriters and Teletype machines, which operated in a similar fashion. The demand for higher speed led to the development of new systems specifically for computer use.\n" +
                                "Personal computer printers can be distinguished as impact or non-impact printers. Early impact printers worked something like an automatic typewriter, with a key striking an inked impression on paper for each printed character . The dot-matrix printer was a popular low-cost personal computer printer. It's an impact printer that strikes the paper a line at a time. The best-known non-impact printers are the inkjet printer, of which several makes of low-cost color printers are an example, and the laser printer . The inkjet sprays ink from an ink cartridge at very close range to the paper as it rolls by. The laser printer uses a laser beam reflected from a mirror to attract ink (called toner ) to selected paper areas as a sheet rolls over a drum.\n" +
                                "Some printers, commonly known as network printers, have built-in network interfaces, typically wireless and/or Ethernet based, and can serve as a hard copy device for any user on the network. Individual printers are often designed to support both local and network connected users at the same time. In addition, a few modern printers can directly interface to electronic media such as memory cards, or to image capture devices such as digital cameras, scanners; some printers are combined with a scanners and/or fax machines in a single unit, and can function as photocopiers. Printers that include non-printing features are sometimes called multifunction printers (MFP), multi-function devices (MFD), or all-in-one (AIO) printers. Most MFPs include printing, scanning, and copying among their features.\n");

                exercises.add(exerciseUnderline7);
                break;
            case 8:
                ExerciseUnderline exerciseUnderline8 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("abbreviated, variation, to evolve¬, wands, reverse, application, impractical, drum, photomultiplier tube, resolution, attractive, disadvantage, distortion, reflection, shadow, advantage, portability, damaging, detection",","),
                        "SCANNER",
                        "A scanner is a device that captures images from photographic prints, posters, magazine pages, and similar sources for computer editing and display. Scanners come in hand-held, feed-in and flatbed types and for scanning black-and-white only, or color. Very high resolution scanners are used for scanning for high-resolution printing, but lower resolution scanners are adequate for capturing images for computer display. Scanners usually come with software, such as Adobe's Photoshop product, that lets you resize and otherwise modify a captured image.\n" +
                                "In computing, an image scanner—often abbreviated to just scanner— is a device that optically scans images, printed text, handwriting, or an object, and converts it to a digital image. Common examples found in offices are variations of the desktop (or flatbed) scanner where the document is placed on a glass window for scanning. Hand-held scanners, where the device is moved by hand, have evolved from text scanning \"wands\" to 3D scanners used for industrial design, reverse engineering, test and measurement, orthotics, gaming and other applications. Mechanically driven scanners that move the document are typically used for large-format documents, where a flatbed design would be impractical.\n" +
                                "Modern scanners typically use a charge-coupled device (CCD) or a Contact Image Sensor (CIS) as the image sensor, whereas older drum scanners use a photomultiplier tube as the image sensor. A rotary scanner, used for high-speed document scanning, is another type of drum scanner, using a CCD array instead of a photomultiplier. Other types of scanners are planetary scanners, which take photographs of books and documents, and 3D scanners, for producing three-dimensional models of objects.\n" +
                                "Another category of scanner is digital camera scanners, which are based on the concept of reprographic cameras. Due to increasing resolution and new features such as anti-shake, digital cameras have become an attractive alternative to regular scanners. While still having disadvantages compared to traditional scanners (such as distortion, reflections, shadows, low contrast), digital cameras offer advantages such as speed, portability and gentle digitizing of thick documents without damaging the book spine. New scanning technologies are combining 3D scanners with digital cameras to create full-color, photo-realistic 3D models of objects.\n" +
                                "In the biomedical research area, detection devices for DNA microarrays are called scanners as well. These scanners are high-resolution systems (up to 1 µm/ pixel), similar to microscopes. The detection is done via CCD or a photomultiplier tube.\n");

                exercises.add(exerciseUnderline8);
                break;
            case 9:
                ExerciseUnderline exerciseUnderline9 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("volatile, RAM, , hard, permanent, backing, surface, to divide, track, sector, to insert, blank, to format, to record, location, entry, optical, WORMs, CD-ROMs, erasable, indelible, reason, to last, permanent, archiving, fields, , medicine, history, gigabyte",","),
                        "STORAGE DEVICES",
                        "A computer storage device is any type of hardware that stores data. The most common type of storage device, which nearly all computers have, is a hard drive. The computer's primary hard drive stores the operating system, applications, and files and folders for users of the computer.\n" +
                                "While the hard drive is the most ubiquitous of all storage devices, several other types are common as well. Flash memory devices, such as USB keychain drives and iPod nanos are popular ways to store data in a small, mobile format. Other types of flash memory, such as compact flash and SD cards are popular ways to store images taken by digital cameras.\n" +
                                "External hard drives that connect via Firewire and USB are also common. These types of drives are often used for backing up internal hard drives, storing video or photo libraries, or for simply adding extra storage. Finally, tape drives, which use reels of tape to store data, are another type of storage device and are typically used for backing up data.\n" +
                                "A data storage device is a device for recor¬ding (sto-ring) infor¬mation (data). Recording can be done using virtually any form of energy, spanning from manual muscle power in handwriting, to acoustic vibrations in phonographic recording, to electromagnetic energy modulating magnetic and optical discs.\n" +
                                "A storage device may hold information, process information, or both. A device that only holds information is a recording me-dium. Devices that process information (data storage equipment) may either access a separate portable (removable) recording medium or a permanent component to store and retrieve information.\n" +
                                "Electronic data storage requires electrical power to store and retrieve that data. Most storage devices that do not require vi-sion and a brain to read data fall into this category. Electromagnetic data may be stored in either an analog data or digital data format on a variety of media. This type of data is considered to be electronically encoded data, whether or not it is electronically stored in a semiconductor device, for it is certain that a semiconductor device was used to record it on its medium.\n");

                exercises.add(exerciseUnderline9);
                break;
            case 10:
                ExerciseUnderline exerciseUnderline10 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("microprocessor, arithmetic, to associate, circuitry, , silicon, chip, transistor, resistor, to measure, string, binary, digits, cathode, ray, dimensional plotter, buffers, to interpret, accumulator, centi-meter, to perform",","),
                        "MICROPROCESSOR",
                        "A microprocessor incorporates the functions of a computer's central processing unit (CPU) on a single integrated circuit (IC), or at most a few integrated circuits. All modern CPUs are micro-processors making the micro- prefix redundant. The microprocessor is a multipurpose, programmable device that accepts digital data as input, processes it according to instructions stored in its memory, and provides results as output. \n" +
                                "The microprocessor is the heart of any normal computer, whether it is a desktop machine, a server or a laptop. The micro-processor you are using might be a Pentium, a K6, a PowerPC, a Sparc or any of the many other brands and types of microprocessors, but they all do approximately the same thing in approximately the same way.\n" +
                                "A microprocessor -also known as a CPU or central processing unit - is a complete computation engine that is fabricated on a single chip. The first microprocessor was the Intel 4004, introduced in 1971. The 4004 was not very powerful -- all it could do was add and subtract, and it could only do that 4 bits at a time. But it was amazing that everything was on one chip. Prior to the 4004, engineers built computers either from collections of chips or from discrete components (transistors wired one at a time). The 4004 powered one of the first portable electronic calculators.\n" +
                                "A microprocessor is the central arithmetic and logic unit of a computer, together with its associated circuitry, scaled down so that it fits on a single silicon chip (sometimes several chips) holding tens of thousands of transistors, resistors and similar circuit element. A typical microprocessor chip measures half a centimeter on a side. The task of the microprocessor is to receive data in the form of strings of binary digits (0’s and 1’s). A typical microprocessor consist sof the following units: a decode and control unit (to interpret instructions from the stored program), the arithmetic and logic unit, or ALU (to perform arithmetic and logic operations), registers (to serve as an easily accessible memory for data which are frequently manipulated), an accumulator (a special register closely associated with the ALU), address buffers (to supply the control memory with the address from which to take the next instruction) and input/output buffers (to read instructions or data into the microprocessor or to send them out).\n");

                exercises.add(exerciseUnderline10);
                break;
            case 11:
                ExerciseUnderline exerciseUnderline11 = new ExerciseUnderline(
                        "I Exersice","Scan the text below and underline these words and word combinations.",
                        ExersiceTypes.UNDERLINE_EX,
                        StringUtils.spillter("a carrier, baud, demodulate, digital information, familiar,                                                   fre¬quency, shift keying, incidental, measured, modulate, multip-lexing, receiver,  the definition,  the goal, to recover, to reproduce, to transmit",","),
                        "Modem",
                        "A modem (modulator-demodulator) is a device that modulates an analog carrier signal to encode digital information, and also demodulates such a carrier signal to decode the transmitted information. The goal is to produce a signal that can be transmitted easily and decoded to reproduce the original digital data. Modems can be used over any means of transmitting analog signals, from driven diodes to radio.\n" +
                                "The most familiar example is a voice band modem that turns the digital data of a personal computer into modulated electrical signals in the voice frequency range of a telephone channel. These signals can be transmitted over telephone lines and demodulated by another modem at the receiver side to recover the digital data.\n" +
                                "Modems are generally classified by the amount of data they can send in a given time unit, normally measured in bits per second (bit/s, or bps). They can also be classified by the symbol rate measured in baud, the number of times the modem changes its signal state per second. For example, the ITU V.21 standard used audio frequency-shift keying, aka tones, to carry 300 bit/s using 300 baud, whereas the original ITU V.22 standard allowed 1,200 bit/s with 600 baud using phase shift keying. \n" +
                                "News wire services in 1920s used multiplex equipment that met the definition, but the modem function was incidental to the multiplexing function, so they are not commonly included in the history of modems.\n");

                exercises.add(exerciseUnderline11);
                break;

        }





    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
