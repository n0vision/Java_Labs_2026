@echo off
chcp 65001 >nul
cd /d "%~dp0"

call compile.bat
if %ERRORLEVEL% NEQ 0 exit /b 1

java -cp out lr5.Main
