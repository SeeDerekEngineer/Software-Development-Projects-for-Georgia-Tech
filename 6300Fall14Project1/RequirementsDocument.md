**Requirements Document**

1 User Requirements
  
  1.1 Software Interfaces

Software will take as input the raw text files of the students' essays available on their local computer.  Software will process text file and return average length of each sentence.

  1.2 User Interfaces

User will provide the file path of their essay as a command line argument for software, and subsequently receive the average word length of their essay.  Additionally, users may specify delimiters for what constitutes a sentence separator as well as the lower limit of the word length for the program.  Any errors that occur will cause the software to give a novice-friendly message advising the user how to best remedy the problem. 

  1.3 User Characteristics

Typical user will be of university level (undergraduate to graduate).  The degree of technical experience will vary from novice to high level proficiency.  The operating systems and computer specifications used by the students will be variable as well.  

2 System Requirements

  2.1 Functional Requirements
    
    2.1.1 Take raw text file as input
      A user must be able to input the file path of their essay (as a raw text file) as a command line argument for the               application. 
    
    2.1.2 Return average word length
      Software must return the average word length of each sentence for the essay, rounded down to the nearest integer.
    
    2.1.3 User specifies sentence separators
      A user must be able to provide the delimiters that will be used to determine where a sentence ends.  Users will specify         this with the flag '-d' in the command line.  If the user does not specify a delimiter, the default delimiters are the          period(.), exclamation point(!), and question mark(?).  The delimiters entered by the user are included with the default        delimiters.
    
    2.1.4 User specifies lower word limit
      A user must be able to specify the lower limit of the word length that specifies the minimum amount of characters that are       registered as a word in the program.  Users will specify this with the flag '-l' in the command line.  If the user does         not specify a lower word limit, the default lower word length is 3, inclusively.
      
  2.2 Non-Functional Requirements
        
    2.2.1 Vanilla Java based
      Software must be based built in java 1.6 or higher with no nonstandard libraries.
    
    2.2.2 Command line compatible application
      Software must compile in the command line using the 'javac' command without any additional options.  All code not part of       the JDK must be included in the source code with the program.  Program must be an application and must be executable            from the command line using the 'java' command.

    2.2.3 Software must throw exceptions with novice-friendly prompts
      Software must be designed to give prompts fit for users of low technical experience to understand why program is failing        to run.  Specifically, software must return error message with possible remedies if the user fails to properly                  input the file path to their essay, delimiters, and/or word limit into the command line, or if they provide the file path       to a non-plain text file.
    
    2.2.4 Software must include novice-friendly user documentation
      Software must include documentation that provides users with easy to follow instructions for those of limited technical         experience.  Specifically, how to input the correct file path so the application can reach the student's essay, and how to       input sentence delimiters and lower word limits.
