[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![LPPL](https://img.shields.io/badge/License-LPPL%20Version%201.3c-orange)](https://www.latex-project.org/lppl/)

[![TU Darmstadt](https://img.shields.io/badge/TU-Darmstadt-blue.svg)](https://www.tu-darmstadt.de/index.en.jsp)
[![TUDa-CI](https://img.shields.io/badge/CTAN-TUDa--CI-blue.svg)](https://ctan.org/pkg/tuda-ci?lang=en)

[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)


# Section name
Templates - LaTeX
- TUDa CI - Beamer

# Description
This directory is used to create exercises for the the Darmstadt University of Technology.

# Programming Languages
- LaTeX

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
<pre><code>&#128194;exercise
 ┣ &#128194;graphics
 ┣ &#128220;main.tex
 ┗ &#128220;preamble.cls
</code></pre>

## Meaning of the directories and files
- `graphics`

    This directory contains the graphics of the document.
- `main.tex`

    This file is the entry point for the document.
- `preamble.cls`

    This file contains the settings for the document.

# Installation
## Requirements
- TeX-Distribution

    [![MiKTeX](https://img.shields.io/badge/TeX--Distribution-MiKTeX-blue)](https://www.tug.org/texlive/)

    [![TeX Live](https://img.shields.io/badge/TeX--Distribution-TeX%20Live-blue)](https://miktex.org/)

- LaTeX Editor (Recommended)

    Instructions can be found on the following website.

    [![Overleaf](https://img.shields.io/badge/Overleaf--LaTeX-TeX%20Live-blue)](https://www.overleaf.com/learn/latex/Choosing_a_LaTeX_Compiler)
- CTAN TUDa-CI

    [![TUDa-CI](https://img.shields.io/badge/CTAN-TUDa--CI-blue.svg)](https://ctan.org/pkg/tuda-ci?lang=en)

The instructions how to the templates can be used can be found in the respective sections.

# Usage
Please use the following structure:
- `graphics`

    This directory contains all images that are necessary for the document.

- `main.tex`

    This file is the main file and should be kept as minimal as possible in order to achieve a structured design. The aim is to divide the content of the document into different sections, if possible (not necessary for smaller documents).

    The advantage of this is that individual sections can be adapted independently of the entire document and have no influence on the others and also reduce the compilation time for the section if you want to see the result of a section.

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

# License
The license for this directory, if nothing is specified, is [LPPL](LICENSE.md).

Please note that the license can be specified in the respective sections.
