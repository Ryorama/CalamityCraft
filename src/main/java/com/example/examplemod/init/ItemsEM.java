package com.example.examplemod.init;

import com.example.examplemod.common.content.items.*;
import com.zeitheron.hammercore.annotations.*;

@SimplyRegister
public class ItemsEM
{
	@RegistryName("example_material")
	public static final ExampleItem EXAMPLE_ITEM = new ExampleItem();

	@RegistryName("swords/example")
	public static final ExampleSword EXAMPLE_SWORD = new ExampleSword(14);
}