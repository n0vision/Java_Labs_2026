@echo off
chcp 65001 >nul
cd /d "%~dp0"

if not exist out mkdir out

dir /s /b src\*.java > sources.txt
javac -encoding UTF-8 -cp "lib\*" -d out @sources.txt
set BUILD_RESULT=%ERRORLEVEL%
del sources.txt

if %BUILD_RESULT% EQU 0 (
    echo Сборка успешна.
) else (
    echo Ошибка сборки.
    exit /b 1
)
