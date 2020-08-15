# BlackBox
The game I made for my 8th grade project at Camellia. More info can be found under the Help tab in-game.

## Java Installation
To install BlackBox you need Java 11. Here is installation instructions for those who do not have it.

### Windows 10
Instructions can be found here, as well as the download links:

[64-bit](https://adoptopenjdk.net/installation.html#x64_win-jre)

[32-bit](https://adoptopenjdk.net/installation.html#x86-32_win-jre)

More detailed instructions instead of theirs to make it easier: 
1. Download from their link to your Downloads folder. Open the app called "Powershell" or "Terminal" and enter: `cd %UserProfile%\Downloads`
2. Skip their 2nd step unless you know what it's for and how to use it.
3. Continue with their instructions starting with 3.

### MacOS X
Instructions can be found here, as well as the download links:

[64-bit](https://adoptopenjdk.net/installation.html#x64_mac-jre)

Most modern Macs are 64-bit, so I will not put instructions for 32-bit Macs.

More detailed instructions instead of theirs to make it easier: 
1. Download from their link to your Downloads folder. Open the app called "Terminal" and enter: `cd ~/Downloads`
2. Skip their 2nd step unless you know what it's for and how to use it.
3. Continue with their instructions starting with 3.

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
