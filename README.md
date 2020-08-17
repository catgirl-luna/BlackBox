# BlackBox
The game I made for my 8th grade project at Camellia. More info can be found under the Help tab in-game.
The game is coded with desktop and laptop computers in mind, specifically, Windows, Mac, and Linux. It can be run on Solaris, but it's very unlikely anyone would want to run this on Solaris specifically.
Installation may seem like a complicated process, but underneath I wrote out step-by-step instructions fow different platforms.

## Java Installation
To install BlackBox you need Java 11. Here is installation instructions for those who do not have it.
If you're not sure about whether you have Java 11 or not, do this:
Enter `java -version` into your Terminal or Command Line. It shoud give back something similar to `openjdk version "11.0.8" 2020-07-14` and a few other lines after.
If it does not say version 11 or gives an error, make sure you have typed it correctly. If you have and nothing changes, follow the instructions beneath.

### Windows 10
Instructions can be found here, as well as the download links:

[64-bit](https://adoptopenjdk.net/installation.html#x64_win-jre)

[32-bit](https://adoptopenjdk.net/installation.html#x86-32_win-jre)

If you do not know whether your computer is 32-bit or 64-bit follow these instructions:
Press and hold your Windows key and Pause key. A new window should pop up.
Find the text "System type:" and it should say 32-bit or 64-bit after.

More detailed instructions instead of theirs to make it easier: 
1. Download from their link to your Downloads folder. Open the app called "Powershell" or "Terminal" and enter: `cd %UserProfile%\Downloads`
2. Skip their 2nd step unless you know what it's for and how to use it.
3. Continue with their instructions starting with 3.

---

### MacOS X
Instructions can be found here, as well as the download links:

[64-bit](https://adoptopenjdk.net/installation.html#x64_mac-jre)

Most modern Macs are 64-bit, so I will not put instructions for 32-bit Macs.

More detailed instructions instead of theirs to make it easier: 
1. Download from their link to your Downloads folder. Open the app called "Terminal" and enter: `cd ~/Downloads`
2. Skip their 2nd step unless you know what it's for and how to use it.
3. Continue with their instructions starting with 3.

---

### Linux
#### Debian-based
**Examples: Debian, Ubuntu, Mint, Kubuntu, Rasberry Pi OS**
Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo apt-get install openjdk-11-jre` and enter your password when prompted.

#### RPM-based
**Examples: Red Hat, CentOS, Fedora, openSUSE**
Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo yum install java-11-openjdk-devel` and enter your password when prompted.

#### Pacman-based
**Examples: Arch**
Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo pacman -Syu jre10-openjdk` and enter your password when prompted.

#### Gentoo-based
**Examples: Chrome OS, Chromium OS**
Open the app called "Terminal" or "Command Line".
Type this command and press Enter.
`sudo emerge --ask dev-java/-jre-bin` and enter your password when prompted.
(I'm actually not sure about this; Gentoo is very different from other Linux systems.)

#### Any other Linux distro
Google it. I can't put all of them in.

#### After any Linux installation
Enter into the Terminal:
`export JAVA_HOME=/usr/lib/jvm/openjdk-11-jdk`
`export PATH=$PATH:$JAVA_HOME/bin`
Verify the installation by entering `java -version`. It shoud give back something similar to `openjdk version "11.0.8" 2020-07-14` and a few other lines after.


## Running the game
Unfortunately, you can't install the game very easily. There are various methods for running the file, however, I will show you what I think is the easiest for each platform.
To download BlackBox.jar, click [this link](https://github.com/odnahaon/BlackBox/raw/master/BlackBox.jar). Refer to your system's instructions for where to download it.

WARNING! Do not delete BlackBox.jar or the file you create in the instructions below. Deleting either will mean that you will have to recreate them to make the game run.

---

### Windows 10
Download **BlackBox.jar** to your Downloads folder. If you want to choose a different folder, change what you type below (if you're sure you can figure it out).
Right click on your desktop and choose New > Shortcut.
Type `"C:\Windows\System32\cmd.exe" /k java -jar %UserProfile%\Downloads\BlackBox.jar` and click `Next`.
Type a name for the shortcut (should use "BlackBox") and click `Finish`.
Double-click the icon with the name you entered (probably "BlackBox") and the game shoud run.

---

### MacOS X
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

---

### Linux
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
