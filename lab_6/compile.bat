@echo off
chcp 65001 >nul
cd /d "%~dp0"

if not exist out mkdir out

dir /s /b src\*.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt
del sources.txt

if %ERRORLEVEL% EQU 0 (
    echo Сборка успешна.
) else (
    echo Ошибка сборки.
    exit /b 1
)
