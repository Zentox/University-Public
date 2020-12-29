[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![LPPL](https://img.shields.io/badge/License-LPPL%20Version%201.3c-orange)](https://www.latex-project.org/lppl/)

[![Java](https://img.shields.io/badge/Programming%20Language-Java-blue.svg)](https://www.oracle.com/java/)
[![Racket](https://img.shields.io/badge/Programming%20Language-Racket-blue.svg)](https://docs.racket-lang.org/htdp-langs/advanced.html)

[![Fop WiSe 2020/2021](https://img.shields.io/badge/Fop-WiSe%202020%2F2021-blue)](https://moodle.informatik.tu-darmstadt.de/course/view.php?id=945)

[![TU Darmstadt](https://img.shields.io/badge/TU-Darmstadt-blue.svg)](https://www.tu-darmstadt.de/index.en.jsp)
[![TUDa-CI](https://img.shields.io/badge/CTAN-TUDa--CI-blue.svg)](https://ctan.org/pkg/tuda-ci?lang=en)


[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)


# Section name
Functional and object-oriented programming concepts - Exercise
- Winter semester 2020/2021

# Description
This directory contains unofficial solutions to the exercises from the winter semester 2020/2021.

# Language
This document is written in German.

# Programming Languages
- LaTeX
- Racket
- Java

# Table of Contents
1. [Section leaders](#Section-leaders)
1. [Section structure](#Section-structure)
1. [Installation](#Installation)
1. [Usage](#Usage)
1. [Credits](#Credits)
1. [License](#License)

# Section leaders
Maintainers:
- [Zentox](https://github.com/Zentox)

# Section structure
<pre><code>&#128194;solution
 ┣ &#128194;00_exercise
 ┣ &#128194;01_exercise
 ┣ &#128194;02_exercise
 ┣ &#128194;03_exercise
 ┣ &#128194;04_exercise
 ┣ &#128194;05_exercise
 ┣ &#128194;06_exercise
 ┣ &#128194;07_exercise
 ┣ &#128194;08_exercise
 ┣ &#128194;09_exercise
 ┣ &#128194;10_exercise
 ┣ &#128220;fopbot.sty
 ┗ &#128220;preamble.cls
</code></pre>

## Meaning of the directories and files
- `00_exercise` - `10_exercise`

    The respective directories contain the solutions to the respective exercise sheets.
- `index.ist`

    This file contains the glossary style of the document.
- `fopbot.sty`

    This file allows to create fop-worlds as graphics.
- `preamble.cls`

    This file contains the settings for the document.

# Installation
## Requirements
- TeX-Distribution

    [![MiKTeX](https://img.shields.io/badge/TeX--Distribution-MiKTeX-blue)](https://www.tug.org/texlive/)

    [![TeX Live](https://img.shields.io/badge/TeX--Distribution-TeX%20Live-blue)](https://miktex.org/)

- LaTeX Editor (Recommended)

    Instructions can be found on the following website.

    [![Overleaf](https://img.shields.io/badge/Overleaf-LaTeX-blue)](https://www.overleaf.com/learn/latex/Choosing_a_LaTeX_Compiler)
- CTAN TUDa-CI

    [![TUDa-CI](https://img.shields.io/badge/CTAN-TUDa--CI-blue.svg)](https://ctan.org/pkg/tuda-ci?lang=en)

The instructions how to the templates can be used can be found in the respective sections.

# Usage
Please use the following structure:
- `XY_exercise`

    This directory contains the solution to the exercise sheet XY.

    - `codes`

    This directory contains all code examples of the document.

    - `graphics`

    This directory contains the graphics of the document.

    - `main.tex`

    This file is the entry point for the document.

    <pre><code>&#128194;XY_exercise
    ┣ &#128194;codes
    ┣ &#128194;graphics
    ┗ &#128220;main.tex
</code></pre>
    (X and Y are placeholders for natural numbers)

- `preamble.cls`

    This file contains all custom settings and use packages. As long as the packages do not have to be tied to a specific location, all packages and settings that are used in the document or sections are stored here.

The files must also have meaningful names to make searching for files more efficient.

# Credits
## Logos & images
- TUDa Logo

    https://download.hrz.tu-darmstadt.de/protected/CE/TUDa_LaTeX/tuda_logo.pdf
    
    The logos used are not part of this bundle and can be downloaded by members of the TU Darmstadt via the internal network.

## Templates
- TUDa-CI – Corporate Design LaTeX-Templates for TU Darmstadt Templates

    https://github.com/tudace/tuda_latex_templates

## Others
- Corporate Design of TU Darmstadt

    https://www.intern.tu-darmstadt.de/arbeitsmittel/corporate_design_vorlagen/index.de.jsp

- FopBot Package

    https://github.com/Rdeisenroth/FOPBot-Latex-Package

# License
The license for this directory, if nothing is specified, is [LPPL](LICENSE.md).

Please note that the license can be specified in the respective sections.
