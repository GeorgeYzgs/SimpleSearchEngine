# SimpleSearchEngine

An application to search for entries within a given database:

The application must be run with a <b>--data</b> command line argument followed by a file path to read as a database.<br>
There is also a sample.txt file you can work with.<br>

The application works with an <b>Inverted Index</b> data structure,so it will only match words that fully match each query and not parts of a word.
It is however case insensitive.

3 strategies have been implemented as search parameters:

<b>ALL</b> strategy will print the entries that contain all the words passed to the console upon request.
<br><b>ANY</b> strategy will print the entries that contain at least one of the words.
<br><b>NONE</b> strategy will print the entries that do not contain any of the words.
