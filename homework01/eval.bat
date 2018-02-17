@echo off
@javac CalendarStuff.java
@javac CalendarStuffTester.java
@javac CountTheDays.java
@java CalendarStuffTester > testerout.txt

@echo Counting 0000 days between 03-15-2005 and 03-15-2005 >> testerout.txt
@java CountTheDays 3 15 2005 3 15 2005 >> testerout.txt

@echo Counting 0001 day  between 03-15-2005 and 03-16-2005 >> testerout.txt
@java CountTheDays 3 15 2005  03 16 2005 >> testerout.txt

@echo Counting 0001 day  between 03-31-2005 and 04-01-2005 >> testerout.txt
@java CountTheDays 3 31 2005  04 01 2005 >> testerout.txt

@echo Counting 0003 days between 12-30-2005 and 01-02-2006 >> testerout.txt
@java CountTheDays 12 30 2005  01 02 2006 >> testerout.txt

@echo Counting 0003 days between 12-30-2005 and 01-02-2006 >> testerout.txt
@java CountTheDays 12 30 2005  01 02 2006 >> testerout.txt

@echo Counting 0366 days between 08-15-2007 and 08-15-2008 >> testerout.txt
@java CountTheDays 8 15 2007  08 15 2008 >> testerout.txt

@echo Counting 0364 days between 08-15-2001 and 08-14-2002 >> testerout.txt
@java CountTheDays 8 15 2001  08 14 2002 >> testerout.txt

@echo Counting 0508 days between 03-15-2006 and 08-05-2007 >> testerout.txt
@java CountTheDays 3 15 2006  08 05 2007 >> testerout.txt

@echo Counting 1239 days between 03-15-2005 and 08-05-2008 >> testerout.txt
@java CountTheDays 3 15 2005  08 05 2008 >> testerout.txt

@echo Counting 1060 days between 11-15-2005 and 10-10-2008 >> testerout.txt
@java CountTheDays 11 15 2005  10 10 2008 >> testerout.txt

@echo Counting 8638 days between 11-15-2001 and 07-10-2025 >> testerout.txt
@java CountTheDays 11 15 2001  07 10 2025 >> testerout.txt

@echo Counting 0001 day  between 03-16-2005 and 03-15-2005 >> testerout.txt
@java CountTheDays 3 16 2005  03 15 2005 >> testerout.txt

more testerout.txt

