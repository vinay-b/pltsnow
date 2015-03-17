1. first you need byacc for java
> <a href='http://byaccj.sourceforge.net/#download'>Link here</a>

2. next once your get the binaries you need to add them somewhere on your path so that the make finds it.

3. now you can go to SVNPATH/src/ and run the makefile
> make mac<br>
<blockquote>make all (for linux)</blockquote>

4. finally to run parser you run the following from the src directory in the svn<br>
<blockquote>make sample1<br>
make sample2<br><br>
and so on or you can use the following<br></blockquote>

<blockquote>java com/google/code/pltsnow/gen/Parser ../sample/sample#.snow</blockquote>

<blockquote>ex: java com/google/code/pltsnow/gen/Parser ../sample/sample3.snow</blockquote>

<blockquote>and you can send it to SnowProgramImp?.java with ">" to refresh the SnowProgramImp?.java in the editor if you have it open.</blockquote>

5. then you can run <br>
<blockquote>make test<br>
which compiles the SnowProgramImp.java which may or may not work depending on<br>
how far our compiler is.</blockquote>

6.	finally if it compiled run<br>
<blockquote>make run