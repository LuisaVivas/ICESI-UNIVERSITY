@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n4_taquilla
REM Autor: Kelvin Guerrero, Luis Ricardo Ruiz y Rafael Mu�oz - 11-mar-2013
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/taquilla.jar;test/lib/junit.jar;test/lib/taquillaTest.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.TaquillaTest

java -ea -classpath lib/taquilla.jar;test/lib/junit.jar;test/lib/taquillaTest.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.PartidoTest

java -ea -classpath lib/taquilla.jar;test/lib/junit.jar;test/lib/taquillaTest.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.SillaTest

java -ea -classpath lib/taquilla.jar;test/lib/junit.jar;test/lib/taquillaTest.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.PersonaTest

cd bin/win