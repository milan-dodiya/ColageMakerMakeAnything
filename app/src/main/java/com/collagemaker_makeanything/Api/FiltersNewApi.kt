package com.collagemaker_makeanything.Api

import com.google.gson.annotations.SerializedName

data class FiltersNewApi(

	@field:SerializedName("baseUrl")
	val baseUrl: String?,

	@field:SerializedName("data")
	val data: ftData?
)

data class Confetti(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class StringLights(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Fantasy(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ftHalloween(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ftData(

	@field:SerializedName("Heart")
	val heart: Heart?,

	@field:SerializedName("Holi")
	val holi: Holi?,

	@field:SerializedName("shape Bokeh")
	val shapeBokeh: ShapeBokeh?,

	@field:SerializedName("Light and Shadow")
	val lightAndShadow: LightAndShadow?,

	@field:SerializedName("Smoke")
	val smoke: Smoke?,

	@field:SerializedName("Torn Paper")
	val tornPaper: TornPaper?,

	@field:SerializedName("Rusty effects")
	val rustyEffects: RustyEffects?,

	@field:SerializedName("Wrinkle Paper")
	val wrinklePaper: WrinklePaper?,

	@field:SerializedName("Leaks")
	val leaks: Leaks?,

	@field:SerializedName("Miracle Light")
	val miracleLight: MiracleLight?,

	@field:SerializedName("Bubble")
	val bubble: Bubble?,

	@field:SerializedName("Fog Overlay")
	val fogOverlay: FogOverlay?,

	@field:SerializedName("Neon")
	val neon: ftNeon?,

	@field:SerializedName("Rainbow")
	val rainbow: Rainbow?,

	@field:SerializedName("Bokeh")
	val bokeh: Bokeh?,

	@field:SerializedName("Fireworks")
	val fireworks: Fireworks?,

	@field:SerializedName("Glitch")
	val glitch: Glitch?,

	@field:SerializedName("Dust and Scratch")
	val dustAndScratch: DustAndScratch?,

	@field:SerializedName("Broken Glass")
	val brokenGlass: BrokenGlass?,

	@field:SerializedName("Xmas Spakle")
	val xmasSpakle: XmasSpakle?,

	@field:SerializedName("Explosion")
	val explosion: Explosion?,

	@field:SerializedName("Autumn")
	val autumn: Autumn?,

	@field:SerializedName("Film Leak")
	val filmLeak: FilmLeak?,

	@field:SerializedName("Grain Splash")
	val grainSplash: GrainSplash?,

	@field:SerializedName("Plastic Wrap")
	val plasticWrap: PlasticWrap?,

	@field:SerializedName("Diamond")
	val diamond: Diamond?,

	@field:SerializedName("Confetti")
	val confetti: Confetti?,

	@field:SerializedName("Spring")
	val spring: Spring?,

	@field:SerializedName("String Lights")
	val stringLights: StringLights?,

	@field:SerializedName("Speed Lines")
	val speedLines: SpeedLines?,

	@field:SerializedName("Powder explosion")
	val powderExplosion: PowderExplosion?,

	@field:SerializedName("face Shadow")
	val faceShadow: FaceShadow?,

	@field:SerializedName("Dreamy light")
	val dreamyLight: DreamyLight?,

	@field:SerializedName("Light Leaks")
	val lightLeaks: LightLeaks?,

	@field:SerializedName("Lightning")
	val lightning: Lightning?,

	@field:SerializedName("Love")
	val love: ftLove?,

	@field:SerializedName("Fire")
	val fire: Fire?,

	@field:SerializedName("Fantasy")
	val fantasy: Fantasy?,

	@field:SerializedName("Rainy Day")
	val rainyDay: RainyDay?,

	@field:SerializedName("Splash")
	val splash: Splash?,

	@field:SerializedName("Halloween")
	val halloween: ftHalloween?,

	@field:SerializedName("Dust and Sunlight")
	val dustAndSunlight: DustAndSunlight?,

	@field:SerializedName("Flurries")
	val flurries: Flurries?,

	@field:SerializedName("Halo")
	val halo: Halo?,

	@field:SerializedName("lens flares")
	val lensFlares: LensFlares?
)

data class Glitch(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class DreamyLight(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Flurries(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class MiracleLight(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Autumn(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class PowderExplosion(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class FaceShadow(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Halo(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Lightning(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Explosion(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ftLove(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ShapeBokeh(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class BrokenGlass(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Rainbow(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class TornPaper(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class RainyDay(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Bokeh(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Bubble(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class LensFlares(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Heart(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class FilmLeak(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class SpeedLines(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Fireworks(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class PlasticWrap(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class DustAndSunlight(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class FogOverlay(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Holi(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Smoke(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class DustAndScratch(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Splash(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ftNeon(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class RustyEffects(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class GrainSplash(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class LightAndShadow(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class WrinklePaper(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Spring(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Leaks(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Diamond(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class LightLeaks(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class Fire(

	@field:SerializedName("Group")
	val group: ftGroup?
)

data class ftGroup(

	val textCategory: String?,

	@field:SerializedName("premium")
	val premium: List<String>?,

	@field:SerializedName("subImageUrl")
	val subImageUrl: List<String>?,

	@field:SerializedName("mainImageUrl")
	val mainImageUrl: List<String>?
)

data class XmasSpakle(

	@field:SerializedName("Group")
	val group: ftGroup?
)
