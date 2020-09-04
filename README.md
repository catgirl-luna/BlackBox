<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
</head>
<body>

# BlackBox
The game I made for my 8th grade project at Camellia. More info can be found under the Help tab in-game.
The game is coded with desktop and laptop computers in mind, specifically, Windows, Mac, and Linux. It can be run on Solaris, but it's very unlikely anyone would want to run this on Solaris specifically.
Installation may seem like a complicated process, but underneath I wrote out step-by-step instructions for different platforms.
<a name=top>

## Table of Contents

- <a href="#JavaInstall" target="_self">Java Installation</a>
  - <a href="#JIWindows" target="_self">Windows 10</a>
  - <a href="#JIMacOS" target="_self">Mac OS X</a>
  - <a href="#JILinux" target="_self">Linux</a>
    - <a href="#Debian" target="_self">Debian-based</a>
    - <a href="#RPM" target="_self">RPM-based</a>
    - <a href="#Pacman" target="_self">Pacman-based</a>
    - <a href="#Gentoo" target="_self">Gentoo-based</a>
    - <a href="#Other" target="_self">Other Linux</a>
    - <a href="#AfterLinux" target="_self">After any Linux installation</a>
- <a href="#RunningGame" target="_self">Running the game</a>
  - <a href="#RGWindows" target="_self">Windows 10</a>
  - <a href="#RGMacOS" target="_self">Mac OS X</a>
  - <a href="#RGLinux" target="_self">Linux</a>

## <a name="JavaInstall"></a>Java Installation
To install BlackBox you need Java 11. Here is installation instructions for those who do not have it.
If you're not sure about whether you have Java 11 or not, do this:
Enter `java -version` into your Terminal or Command Line. It shoud give back something similar to `openjdk version "11.0.8" 2020-07-14` and a few other lines after.
If it does not say version 11 or gives an error, make sure you have typed it correctly. If you have and nothing changes, follow the instructions beneath.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="JIWindows"></a>Windows 10
Instructions can be found here, as well as the download links:

[64-bit](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10/OpenJDK11U-jre_x64_windows_hotspot_11.0.8_10.msi)

[32-bit](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10/OpenJDK11U-jre_x86-32_windows_hotspot_11.0.8_10.msi)

If you do not know whether your computer is 32-bit or 64-bit follow these instructions:
Press and hold your Windows key and Pause key. A new window should pop up.
Find the text "System type:" and it should say 32-bit or 64-bit after.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="JIMacOS"></a>Mac OS X
Instructions can be found here, as well as the download links:

[64-bit](https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%2B10/OpenJDK11U-jre_x64_mac_hotspot_11.0.8_10.pkg)

Most modern Macs are 64-bit, so I will not put instructions for 32-bit Macs.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="JILinux"></a> Linux
#### <a name="Debian"></a> Debian-based
**Examples: Debian, Ubuntu, Mint, Kubuntu, Rasberry Pi OS**

Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo apt-get install openjdk-11-jre` and enter your password when prompted.

<a href="#top" target="_self">[Table of Contents]</a>

#### <a name="RPM"></a> RPM-based
**Examples: Red Hat, CentOS, Fedora, openSUSE**

Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo yum install java-11-openjdk-devel` and enter your password when prompted.

<a href="#top" target="_self">[Table of Contents]</a>

#### <a name="Pacman"></a> Pacman-based
**Examples: Arch**

Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo pacman -Syu jre10-openjdk` and enter your password when prompted.

<a href="#top" target="_self">[Table of Contents]</a>

#### <a name="Gentoo"></a> Gentoo-based
**Examples: Chrome OS, Chromium OS**

Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo emerge --ask dev-java/-jre-bin` and enter your password when prompted.
(I'm actually not sure about this; Gentoo is very different from other Linux systems.)

<a href="#top" target="_self">[Table of Contents]</a>

#### <a name="Other"></a> Any other Linux distro
Google it. I can't put all of them in.

<a href="#top" target="_self">[Table of Contents]</a>

#### <a name="AfterLinux"></a> After any Linux installation
Enter into the Terminal:
`export JAVA_HOME=/usr/lib/jvm/openjdk-11-jdk`
`export PATH=$PATH:$JAVA_HOME/bin`
Verify the installation by entering `java -version`. It shoud give back something similar to `openjdk version "11.0.8" 2020-07-14` and a few other lines after.

<a href="#top" target="_self">[Table of Contents]</a>


## <a name="RunningGame"></a> Running the game
Unfortunately, you can't install the game very easily. There are various methods for running the file, however, I will show you what I think is the easiest for each platform.
To download BlackBox.jar, click [this link](https://github.com/odnahaon/BlackBox/raw/master/BlackBox.jar). Refer to your system's instructions for where to download it.

WARNING! Do not delete BlackBox.jar or the file you create in the instructions below. Deleting either will mean that you will have to recreate them to make the game run.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="RGWindows"></a> Windows 10
Download **BlackBox.jar** to your Downloads folder. If you want to choose a different folder, change what you type below (if you're sure you can figure it out).
Right click on your desktop and choose New > Shortcut.
Type `"C:\Windows\System32\cmd.exe" /k java -jar %UserProfile%\Downloads\BlackBox.jar` and click `Next`.
Type a name for the shortcut (should use "BlackBox") and click `Finish`.
Double-click the icon with the name you entered (probably "BlackBox") and the game shoud run.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="RGMacOS"></a> Mac OS X
Download **BlackBox.jar** to your Downloads folder. If you want to choose a different folder, change what you type below (if you're sure you can figure it out).
Open the application "TextEdit" and click "New Document".
Type `#!/bin/bash
java -jar ~/Downloads/BlackBox.jar`
Click Format > Make Plain Text
Click File > Save
Save it as something you can remember (should use "BlackBox") and save to your desktop.
Uncheck the box that says "If no extension is provided, use '.txt'."
Open "Terminal" and type `chmod 755 ~/Desktop/BlackBox`
Now double-click on the file labled "BlackBox" on your Desktop and the game should run.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="RGLinux"></a> Linux
Download **BlackBox.jar** to your Downloads folder. If you want to choose a different folder, change what you type below (if you're sure you can figure it out).
Open your favorite text editor. Some defaults are:
Gedit; Kwrite; nano; vi or vim; emacs
I reccommend using Gedit or Kwrite for Linux beginners.
Type `#!bin/bash
java -jar ~/Downloads/BlackBox.jar`
Save it with a name you can remember followed by .sh (should use "BlackBox.sh") and put on your Desktop.
Open the app "Terminal" or "Command Line" and type `chmod +x ~/Desktop/BlackBox.sh`
Now double-click on the file labled "BlackBox.sh" on your Desktop and the game should run.
Some Linux distros may vary slightly, but this should work.

<a href="#top" target="_self">[Table of Contents]</a>

---

### <a name="Advanced"></a> Advanced

*DISCLAIMER: This README.md file was made for Github's formatting. It may display differently on other Markdown previewers/parsers.*

If you want to get the source code, download the "src" and "resource" directories. Compiling these (unchanged) will create a file identical to BlackBox.jar. Make sure to read the [license](https://github.com/odnahaon/BlackBox/blob/master/LICENSE)!
