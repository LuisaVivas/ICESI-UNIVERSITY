@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n3_carroComprasLibros
REM Autor: Jorge Jim�nez - 23-Jun-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecuci�n de las pruebas
REM ---------------------------------------------------------
cd..
java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.TiendaLibrosTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.LibroTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.ItemCompraTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.CarroCompraTest

cd bin