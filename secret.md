Prixilium — Fabric Minecraft Mod
Author: NapsterNPT | Version: 1.0.0 | MC: 1.21.5 | Loader: Fabric | License: LGPL-3.0
---
Core Concept
A virus-themed Fabric mod. A fictional organism called "Prixilium" spreads across the world, infecting blocks and creating hazardous biological mechanics around infection, illness, and contamination.
---
Key Mechanics
Spreading Infection
- PrixiliumGrassBlock spreads on random ticks, converting dirt/grass, logs, wood, and flowers into their "Prixiled" variants within 5 blocks.
- Can be cured with Shears (drops a Prixilium item).
  Deceptive Illness System (mixin-powered)
- Virus (Alive) item ages every 50 ticks. When it dies, the player gets the Illness effect.
- Illness is invisible on the HUD (HideIllnessMixin), cannot be cured by milk (MilkBucketMixin), and causes the player to be teleported to the Nether on waking from sleep (PlayerSleepMixin).
  Custom Entities
  Entity	Type
  Bliko	Tameable (passive)
  Blokito	Hostile (zombie-type)
  Airis	Hostile
  Prixilium Hook	Projectile
  "Prixiled" Equipment
- All vanilla tool/armor tiers have unbreakable Prixiled variants, upgraded via a custom Smithing Template.
  Other Content
- Prixilium Lamp (0–15 redstone-controlled brightness)
- Virus Reactor block entity (displays a rotating item inside)
- Custom tree feature (5–8 block tall, glowing teal leaves)
- Charm system (3 tiers × 5 types) — framework exists, effects partially stubbed
- Potion of Prixilium Slowness
---
What's Stubbed / Planned
- Prixiverse dimension — currently hardcoded to Nether, custom dimension key exists in a comment
- World gen injection — tree feature registered but not placed in any biome
- Copper tools/armor — commented out, marked 1.21.9+
- Charm effects — items registered but no active game logic yet
- Thermometer — registered, no behavior

Need:
min + random.nextDouble() * (max - min)