[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![LPPL](https://img.shields.io/badge/License-LPPL%20Version%201.3c-orange)](https://www.latex-project.org/lppl/)

[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)


# Section name
Templates - LaTeX
- Packages

# Description
 This directory contains custom packages, which can be used for different activities.

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
<pre><code>&#128194;packages
 ┗ &#128194;tex
   ┗ &#128194;latex
</code></pre>

## Meaning of the directories
- tex/latex
    
    This directory contains the custom packages.


# Installation
## Requirements
- TeX-Distribution

    [![MiKTeX](https://img.shields.io/badge/TeX--Distribution-MiKTeX-blue)](https://www.tug.org/texlive/)

    [![TeX Live](https://img.shields.io/badge/TeX--Distribution-TeX%20Live-blue)](https://miktex.org/)

- LaTeX Editor (Recommended)

    Instructions can be found on the following website.

    [![Overleaf](https://img.shields.io/badge/Overleaf-LaTeX-blue)](https://www.overleaf.com/learn/latex/Choosing_a_LaTeX_Compiler)

The instructions how to the templates can be used can be found in the respective sections.

## Global package access
The packages can be added as a root directory in the TeX-Distribution.
- MiKTeK
    https://miktex.org/kb/texmf-roots
    https://miktex.org/kb/tds

- TeX Live
    https://www.tug.org/texlive/doc/texlive-en/texlive-en.html

# Usage
Please use the structure, which can be seen in the section structure.
1. Include an identification.
    ```tex
    %%% Identification

    \def\fileversion{X.YZ}
    \def\filedate{YYYY/MM/DD}

    % Sets the LaTeX version for the package to work.
    \NeedsTeXFormat{LaTeX2e}

    % Identification of the package and its date and version.
    \ProvidesPackage{codelistings} [\filedate\space\fileversion Description]
    ```
    (X, Y and Z are placeholders for natural numbers)
2. List all packages required for this custom package,
    ```tex
    %%% Packages
    \RequirePackage{XY}
    ```
    (XY are placeholders for a package name)
3. Define the settings.
    ```tex
    %%% Settings
    ...
# License
The license for this directory, if nothing is specified, is [LPPL](LICENSE.md).

Please note that the license can be specified in the respective sections.
