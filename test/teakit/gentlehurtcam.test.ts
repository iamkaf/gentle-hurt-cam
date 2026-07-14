import { Capability, Readiness, describe, expect, test } from "@teakit/test";

describe.configure({
  timeout: "6m",
  readiness: [Readiness.ClientReady, Readiness.IntegratedServerReady, Readiness.PlayerSpawned],
  capabilities: [
    Capability.RuntimeTiming,
    Capability.ServerCommands,
    Capability.WorldBlock,
    Capability.WorldFill,
  ],
});

describe("Gentle Hurt Cam", () => {
  test("survives no-effective-damage and normal damage smoke checks", async ({ commands, runtime, world }) => {
    await commands.run("/gamemode survival");
    await commands.run("/difficulty peaceful");
    await commands.run("/effect clear @s");
    await commands.run("/effect give @s minecraft:resistance 10 255 true");
    await commands.run("/tp @s 0.5 80 0.5 0 0");
    await world.clear({ x: -3, y: 80, z: -3 }, { x: 3, y: 84, z: 3 });
    await world.fill({ x: -3, y: 79, z: -3 }, { x: 3, y: 79, z: 3 }, "minecraft:glass");

    await commands.run("/damage @s 1 minecraft:generic");
    await runtime.wait(500, { timeoutMs: 2_000 });
    await commands.run("/effect clear @s");
    await commands.run("/damage @s 1 minecraft:generic");
    await runtime.wait(500, { timeoutMs: 2_000 });

    await commands.assert("/execute if entity @s");
    await expect(() => world.block({ x: 0, y: 79, z: 0 })).toEventuallyEqual(
      expect.objectContaining({ id: "minecraft:glass" }),
      { timeout: "3s" },
    );
  });
});
