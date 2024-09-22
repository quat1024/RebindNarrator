# Rebind Narrator

Adds an option to the controls screen under "misc" to rebind the narrator key. That's all it does. ~~Fabric~~ Fabric and Forge ~~1.16.1~~ ~~1.17.0~~ ~~1.18.2~~ ~~1.19.2~~ ~~1.19.4~~ ~~1.20~~ ~~1.20.1~~ 1.21.1.

## Fabric version

<details><summary>Integration with AMECS/NMUK (disabled in 1.21)</summary>

**AMECS integration.** If you have [AMECS](https://www.curseforge.com/minecraft/mc-mods/amecs) installed, it will honor your choice of modifier keys & allow for multiple keybindings. This is notable because the narrator key is processed super early on, way before the vanilla keybinds system/AMECS can have a say.

**NMUK integration.** If you have [No More Useless Keys](https://www.curseforge.com/minecraft/mc-mods/nmuk) installed, it will honor your choice of alternate keybindings. Same deal here.

### If AMECS is *not* installed

</details>

The vanilla behavior of requiring a Ctrl press will still be in effect. If you bind narrator to `K` for instance, you would toggle it by pressing `Ctrl-K`.

## Forge version

**Forge integration**. Will honor your choice of modifier keys in the Forge keybindings screen. Will appear in the global KeyConflictContext.

## Known limitations

The narrator key is processed very early on before reaching Minecraft's normal keybinding system, for some reason. (That this mod works at all is a miracle.)

* Binding the narrator key to a mouse button will probably not work.
* (forge/amecs/whatever) Making the keybinding entirely out of modifier keys (such as `Ctrl+Shift` and nothing else) will not work.
