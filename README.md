# Gentle Hurt Cam

A Minecraft mod that cancels the hurt camera effect when you take zero damage.

## Features

**No More Shake for Zero Damage**
When you take damage that's fully absorbed (by armor, enchantments, or other protection), the hurt camera shake effect is cancelled. Your screen won't shake when you don't actually take any damage.

## Compatibility

- Loaders: Fabric, Forge, NeoForge
- Dependencies: Amber

## How It Works

The mod monitors the hurt camera effect and cancels it when:
- Your entity was recently hurt (`hurtTime` is active)
- But the actual damage taken was less than 0.5 hearts (`lastHurt < 0.5`)

This means when you have full netherite armor or other damage reduction that absorbs all incoming damage, your view stays steady.

## Directory Layout

- `common/` contains code shared between all loaders
- `fabric/`, `forge/`, `neoforge/` contain loader-specific entry points and build logic
- `buildSrc/` holds the Gradle scripts that wire everything together

## License

MIT
