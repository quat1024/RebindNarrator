# Rebind Narrator

[![License](https://img.shields.io/badge/License-No%20Restriction-green.svg?style=flat-square)](https://creativecommons.org/publicdomain/zero/1.0/)

Tiny mod/coremod to fix [MC-122645](https://bugs.mojang.com/browse/MC-122645), the inability to rebind or disable the CTRL-B hotkey for the narrator.

This mod adds an entry to the vanilla keyboard controls GUI. It defaults to the same binding as vanilla, but you can change or remove it, just like with any other ley.

# License

This software is public domain, under CC0. I do not care what you do with it or where you distribute it. 

### Technical details

This mod consists of two parts: a coremod, that patches Minecraft.java's hardcoded check for CTRL-B, and a regular mod, that adds the keybinding option to the screen.

I patch Minecraft by reassigning the key from 0x30, B, to 0x54, which is not an assigned key under LWJGL 2. It shouldn't be possible to press, but open a bug report if you can.