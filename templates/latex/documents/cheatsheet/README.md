[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![LPPL](https://img.shields.io/badge/License-LPPL%20Version%201.3c-orange)](https://www.latex-project.org/lppl/)

[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)


# Section name
Templates - LaTeX
- Cheatsheet

# Description
This directory contains a template to create cheatsheets.

# Programming Languages
- LaTeX

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
<pre><code>&#128194;template
 ┣ &#128194;contents
 ┣ &#128194;graphic
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

    [![Overleaf](https://img.shields.io/badge/Overleaf-LaTeX-blue)](https://www.overleaf.com/learn/latex/Choosing_a_LaTeX_Compiler)

# Usage
Please use the following structure:
- `contents`

    This directory contains the content of the document. Each content should be seprated in a seperate directory.
    <pre><code>&#128194;contents
    ┣ &#128194;XY_content
    ┗ &#128220;content.tex
    </code></pre>
    (X and Y are placeholders for natural numbers)
    
    The document body of a content must follow this structure
    ```tex
    \begin{cheatcols}
    \begin{cheatbox}{Cheatbox 1}
            Content
        \end{cheatbox}
        ...
        \begin{cheatbox}{Cheatbox n}
            Content
        \end{cheatbox}
    \end{cheatcols}
    ```
- `graphics`

    This directory contains all images that are necessary for the document.

- `preamble.cls`

    This file contains all custom settings and use packages. As long as the packages do not have to be tied to a specific location, all packages and settings that are used in the document or sections are stored here.
- `main.tex`

    This file is the main file and represents the complete document. The contents of the document are written here.

The files must also have meaningful names to make searching for files more efficient.

## Structure
<pre><code>&#128194;template
 ┣ &#128194;contents
 ┣ &#128194;graphic
 ┣ &#128220;bibliography.bib
 ┣ &#128220;index.ist
 ┣ &#128220;main.tex
 ┗ &#128220;preamble.cls
</code></pre>

# License
The license for this directory, if nothing is specified, is [LPPL](LICENSE.md).

Please note that the license can be specified in the respective sections.
