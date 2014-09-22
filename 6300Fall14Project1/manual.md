From the command line, enter "javac Main.java filepath", where "filepath" is the location of the file on your local computer.
Hit enter.

Optionally, you can also: 

1.  Edit the characters used to determine the endings of sentences(delimiters).
After writing the filepath in java, enter the flag '-d', put a space, then ' "[yourDelimiters]" '
where 'yourdelimiters' are whatever characters you choose.  They do not need to be seperated by commas or spaces.
To enter the period as a delimiter, use \\.
Otherwise, enter all punctuation as normal.
For example, javac Main.java <filepath> -d "[\\.?!,$]"
If you elect to not use this option, the default delimiters are the period, exclamation point, and question mark.
If you do use this option, in addition to whatever characters you choose, you must include these three punctuation marks 
if you want them to be used as delimiters, otherwise they will not be used.

2.  Edit the minimum word length used.
After writing the filepath in java, enter the flag '-l', put a space, then enter the number you wish to be used
as the minimum size a word must be to be counted in a sentence.  The number must be an integer (i.e., 1,2,3,4,5).
If you elect to not use this option, the default minimum word length is 4.


Either one, both, or none of the optional methods can be used.  The order in which they are done does not matter,
provided they include their necessary elements directly after their respective flags.  Additionally, the optional methods
must come after the filepath in the command line.
