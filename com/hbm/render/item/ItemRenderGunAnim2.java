package com.hbm.render.item;

import org.lwjgl.opengl.GL11;

import com.hbm.items.ModItems;
import com.hbm.lib.RefStrings;
import com.hbm.render.model.ModelB92;
import com.hbm.render.model.ModelB93;
import com.hbm.render.model.ModelBoltAction;
import com.hbm.render.model.ModelLeverAction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemRenderGunAnim2 extends TEISRBase {

	protected ModelLeverAction leveraction;
	protected ModelBoltAction boltaction;
	protected ModelB92 b92;
	protected ModelB93 b93;
	protected ResourceLocation leverActionLoc = new ResourceLocation(RefStrings.MODID +":textures/models/ModelLeverAction.png");
	
	public ItemRenderGunAnim2() {
		leveraction = new ModelLeverAction();
		boltaction = new ModelBoltAction();
		b92 = new ModelB92();
		b93 = new ModelB93();
	}
	
	@Override
	public void renderByItem(ItemStack item) {
		if(item.getItem() == ModItems.gun_lever_action/* || item.getItem() == ModItems.gun_lever_action_sonata*/)
			Minecraft.getMinecraft().renderEngine.bindTexture(leverActionLoc);
		switch(type){
		case FIRST_PERSON_LEFT_HAND:
		case FIRST_PERSON_RIGHT_HAND:
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			if (type == TransformType.FIRST_PERSON_RIGHT_HAND) {
				GL11.glTranslated(-0.2, 1.5, 0.4);
				GL11.glRotated(-10, 0, 1, 0);
				GL11.glRotated(-20, 0, 0, 1);
				GL11.glRotated(180, 1, 0, 0);
			} else {
				GL11.glTranslated(1.8, 1.5, 0.8);
				GL11.glRotated(180, 1, 0, 0);
				GL11.glRotated(180, 0, 1, 0);
				GL11.glRotated(23, 0, 0, 1);
			}
			if(item.getItem() == ModItems.gun_lever_action)
				leveraction.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case THIRD_PERSON_LEFT_HAND:
		case THIRD_PERSON_RIGHT_HAND:
		case GROUND:
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslated(1.0, 0.5, 0.5);
			GL11.glRotated(-90, 0, 1, 0);
			GL11.glRotated(180, 1, 0, 0);
			if(item.getItem() == ModItems.gun_lever_action)
				leveraction.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			break;
		}
	}
}