[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![GNU General Public License](https://img.shields.io/badge/License-GNU%20GPL%20Version%203-orange)](https://www.gnu.org/licenses/gpl-3.0.de.html)

[![Java](https://img.shields.io/badge/Programming%20Language-Java-blue.svg)](https://www.oracle.com/java/)
[![Gradle](https://img.shields.io/badge/Build--Tool-Gradle%206.7-blue.svg)](https://docs.gradle.org/current/userguide/userguide.html)

[![Fop WiSe 2020/2021](https://img.shields.io/badge/Fop-WiSe%202020%2F2021-blue)](https://moodle.informatik.tu-darmstadt.de/course/view.php?id=945)

[![TU Darmstadt](https://img.shields.io/badge/TU-Darmstadt-blue.svg)](https://www.tu-darmstadt.de/index.en.jsp)
[![TUDa-CI](https://img.shields.io/badge/CTAN-TUDa--CI-blue.svg)](https://ctan.org/pkg/tuda-ci?lang=en)


[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)

# Section name
Basic-Template
- Functional and object-oriented programming concepts - Java basic programming
- Wintersemester 2020/2021

# Description
This directory serves as a basis for practicing programming concepts, especially the basics. This also includes algorithms and data structures.

# Language
This project is written in English.

# Programming Languages
- Java

# Table of Contents
1. [Section leaders](#Section-leaders)
1. [Section structure](#Section-structure)
1. [Installation](#Installation)
1. [Usage](#Usage)
1. [License](#License)

# Section leaders
Maintainers:
- [Zentox](https://github.com/Zentox)

# Section structure
<pre><code>&#128194;basic-template
 ┣ &#128194;doc
 ┣ &#128194;res
 ┣ &#128194;src
 ┃ ┣ &#128194;main
 ┃ ┗ &#128194;test
 ┗ &#128220;build.gradle
</code></pre>

## Meaning of the directories and files
- `doc`


    This directory contains the documentation of the project (JavaDoc).
- `res`
    
    This directory contains the resources of the project.
- `src`
    - `main`

    This directory contains the main source code of this project.
    - `test`

    This directory contains the test cases of source code in `main` of this project.
- `build.gradle`

    This file defines build configurations for the build automation tool gradle.

# Installation
## Requirements
- Java Version 11
- Gradle Version 6.7

## IDE
- IntelliJ

    The project can be opened in the IDE via `build.gradle`.
- Eclipse

    The project can be opened in the IDE via selecting the root folder of this project.

# Usage
Please use the following structure:
- `doc`

    JavaDoc can be generated via the JavaDoc tool. For more information follow the link below.
    https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html
- `res`

    This directory is used to store resources needed for this project. Please use this directory to store your resources and also create a sub-directory for context-specific resources.
- `src`
    - `main` 
       
       This directory contains the main soruce code. It only contains the source code without test cases. All source code should be included in this directory.
    - `test`

        This directory contains the test cases for the respective classes. All test cases should be included in this directory to seperate the tests from the source code.

Please use meaningful names for the packages and also do not forget to add documentation and comments to make the project more readable and understandable.

# License
The license for this directory, if nothing is specified, is [GNU General Public License](LICENSE.md).

Please note that the license can be specified in the respective sections.
