# Reach Addon

Meteor Client Addon - Extend block and entity reach for Minecraft 1.20.4 (Fabric)

## Features
- Extend block interaction range (0-8 extra blocks)
- Extend entity attack range (0-6 extra blocks, toggleable)
- Client-side raycast fix for correct rendering

## Requirements
- Minecraft 1.20.4
- Fabric Loader 0.15.3+
- Fabric API 0.96.4+1.20.4
- Meteor Client 0.5.6

## Build
```bash
./gradlew clean build
```
Output: `build/libs/reachaddon-1.0.0.jar`

## Install
Copy `reachaddon-1.0.0.jar` to `.minecraft/mods/`

## Usage
Meteor GUI → Modules → Combat → Block Reach
