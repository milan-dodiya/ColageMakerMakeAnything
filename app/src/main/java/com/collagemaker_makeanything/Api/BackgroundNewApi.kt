package com.collagemaker_makeanything.Api

import com.google.gson.annotations.SerializedName

data class BackgroundNewApi(

	@field:SerializedName("baseUrl")
	val baseUrl: String?,

	@field:SerializedName("data")
	val data: bgData?
)

data class CheckeredHearts(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class FathersDay(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ChildrensDay(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ThinkPink(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class KaleidoscopePattern(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BabyBoom(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyPrideMonth(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class LoveYouMom(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BeMine(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyHalloween(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Patnicks(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BlackWhite(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class WaterFiltration(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyNewYear(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class OurDreamWedding(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Pinky(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class WelcomeAutumn(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class RememberMe(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class bgGroup(
	val textCategory: String?,

	@field:SerializedName("premium")
	val premium: List<String>?,

	@field:SerializedName("subImageUrl")
	val subImageUrl: List<String>?,

	@field:SerializedName("mainImageUrl")
	val mainImageUrl: List<String>?
)

data class VintagePaperTexture(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class JobBoards(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class CrumpledKraftPaper(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class SuperDad(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Ramjan(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class AllAboutTheLove(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Holiday(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyMothersDay(

	@field:SerializedName("Group")
	val group: bgGroup?

)

data class Dots(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Pumkin(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Pumpkin(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Abstract(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Oasis(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyHour(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Lucky(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class SummerGame(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class UnicornAreReal(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Paper(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class PrideMonth(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class FadeTexture(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class TropicalVibes(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Ester(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyEaster(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class GraduationSeason(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class PeachFuzzVibes(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class JapanesePattern(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Daisy(

	@field:SerializedName("Group")
	val group: bgGroup?
)

data class bgSummer(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class bgData(

	@field:SerializedName("i love you mom")
	val iLoveYouMom: ILoveYouMom?,

	@field:SerializedName("I love You")
	val iLoveYou: ILoveYou?,

	@field:SerializedName("Patnicks")
	val patnicks: Patnicks?,

	@field:SerializedName("XOXO")
	val xOXO: XOXO?,

	@field:SerializedName("trick or treat")
	val trickOrTreat: TrickOrTreat?,

	@field:SerializedName("pumkin")
	val pumkin: Pumkin?,

	@field:SerializedName("happy childrens day")
	val happyChildrensDay: HappyChildrensDay?,

	@field:SerializedName("Our Dream Wedding")
	val ourDreamWedding: OurDreamWedding?,

	@field:SerializedName("think pink")
	val thinkPink: ThinkPink?,

	@field:SerializedName("Childlike Graffiti")
	val childlikeGraffiti: ChildlikeGraffiti?,

	@field:SerializedName("merry christmas")
	val merryChristmas: MerryChristmas?,

	@field:SerializedName("Fade texture")
	val fadeTexture: FadeTexture?,

	@field:SerializedName("wrap it up")
	val wrapItUp: WrapItUp?,

	@field:SerializedName("Space")
	val space: Space?,

	@field:SerializedName("falling in love")
	val fallingInLove: FallingInLove?,

	@field:SerializedName("holographic")
	val holographic: Holographic?,

	@field:SerializedName("Happy Labour Day")
	val happyLabourDay: HappyLabourDay?,

	@field:SerializedName("Worldwide")
	val worldwide: Worldwide?,

	@field:SerializedName("Oasis")
	val oasis: Oasis?,

	@field:SerializedName("Ramjan")
	val ramjan: Ramjan?,

	@field:SerializedName("woldlife")
	val woldlife: Woldlife?,

	@field:SerializedName("Gold Dust")
	val goldDust: GoldDust?,

	@field:SerializedName("Daisy")
	val daisy: Daisy?,

	@field:SerializedName("happy birthday")
	val happyBirthday: HappyBirthday?,

	@field:SerializedName("Pinky")
	val pinky: Pinky?,

	@field:SerializedName("Watercolor")
	val watercolor: Watercolor?,

	@field:SerializedName("Summer Game")
	val summerGame: SummerGame?,

	@field:SerializedName("childrens day")
	val childrensDay: ChildrensDay?,

	@field:SerializedName("tropical vibes")
	val tropicalVibes: TropicalVibes?,

	@field:SerializedName("happy thanksgiving")
	val happyThanksgiving: HappyThanksgiving?,

	@field:SerializedName("Memphis Event")
	val memphisEvent: MemphisEvent?,

	@field:SerializedName("Dots")
	val dots: Dots?,

	@field:SerializedName("Winter wonderland")
	val winterWonderland: WinterWonderland?,

	@field:SerializedName("happy hour")
	val happyHour: HappyHour?,

	@field:SerializedName("Note and Paper")
	val noteAndPaper: NoteAndPaper?,

	@field:SerializedName("Pink Wedding")
	val pinkWedding: PinkWedding?,

	@field:SerializedName("happy pride month")
	val happyPrideMonth: HappyPrideMonth?,

	@field:SerializedName("Hello Fall")
	val helloFall: HelloFall?,

	@field:SerializedName("hello spring")
	val helloSpring: HelloSpring?,

	@field:SerializedName("Love you mom")
	val loveYouMom: LoveYouMom?,

	@field:SerializedName("Pattern")
	val pattern: Pattern?,

	@field:SerializedName("be mine")
	val beMine: BeMine?,

	@field:SerializedName("Peach fuzz vibes")
	val peachFuzzVibes: PeachFuzzVibes?,

	@field:SerializedName("Abstract")
	val abstract: Abstract?,

	@field:SerializedName("happy graduation")
	val happyGraduation: HappyGraduation?,

	@field:SerializedName("Dia De Muertos")
	val diaDeMuertos: DiaDeMuertos?,

	@field:SerializedName("tropical")
	val tropical: Tropical?,

	@field:SerializedName("Pool Party")
	val poolParty: PoolParty?,

	@field:SerializedName("super dad")
	val superDad: SuperDad?,

	@field:SerializedName("Holiday")
	val holiday: Holiday?,

	@field:SerializedName("Eid Al Adha")
	val eidAlAdha: EidAlAdha?,

	@field:SerializedName("Happy Holi")
	val happyHoli: HappyHoli?,

	@field:SerializedName("Love Terims")
	val loveTerims: LoveTerims?,

	@field:SerializedName("job boards")
	val jobBoards: JobBoards?,

	@field:SerializedName("Botanical")
	val botanical: Botanical?,

	@field:SerializedName("Summer")
	val summer: bgSummer?,

	@field:SerializedName("Welcome autumn")
	val welcomeAutumn: WelcomeAutumn?,

	@field:SerializedName("vintage paper")
	val vintagePaper: VintagePaper?,

	@field:SerializedName("happy new year")
	val happyNewYear: HappyNewYear?,

	@field:SerializedName("Ester")
	val ester: Ester?,

	@field:SerializedName("halloween")
	val halloween: Halloween?,

	@field:SerializedName("Kaleidoscope Pattern")
	val kaleidoscopePattern: KaleidoscopePattern?,

	@field:SerializedName("Summer Time")
	val summerTime: SummerTime?,

	@field:SerializedName("fathers day")
	val fathersDay: FathersDay?,

	@field:SerializedName("Autumn")
	val autumn: Autumnn?,

	@field:SerializedName("pride month")
	val prideMonth: PrideMonth?,

	@field:SerializedName("Bohemian Patterns")
	val bohemianPatterns: BohemianPatterns?,

	@field:SerializedName("happy easter")
	val happyEaster: HappyEaster?,

	@field:SerializedName("happy mothers day")
	val happyMothersDay: HappyMothersDay?,

	@field:SerializedName("Marble")
	val marble: Marble?,

	@field:SerializedName("christmas")
	val christmas: bgChristmas?,

	@field:SerializedName("Fair Trade Fruits")
	val fairTradeFruits: FairTradeFruits?,

	@field:SerializedName("Floral")
	val floral: Floral?,

	@field:SerializedName("Lucky")
	val lucky: Lucky?,

	@field:SerializedName("valentine day")
	val valentineDay: ValentineDay?,

	@field:SerializedName("Happy Halloween")
	val happyHalloween: HappyHalloween?,

	@field:SerializedName("sweet little family")
	val sweetLittleFamily: SweetLittleFamily?,

	@field:SerializedName("best day ever")
	val bestDayEver: BestDayEver?,

	@field:SerializedName("happy diwali")
	val happyDiwali: HappyDiwali?,

	@field:SerializedName("welcome back to school")
	val welcomeBackToSchool: WelcomeBackToSchool?,

	@field:SerializedName("Love")
	val love: bgLove?,

	@field:SerializedName("Checkered Hearts")
	val checkeredHearts: CheckeredHearts?,

	@field:SerializedName("flower vintage")
	val flowerVintage: FlowerVintage?,

	@field:SerializedName("unicorn are real")
	val unicornAreReal: UnicornAreReal?,

	@field:SerializedName("emoji banner")
	val emojiBanner: EmojiBanner?,

	@field:SerializedName("ARTISTIC")
	val aRTISTIC: ARTISTIC?,

	@field:SerializedName("uicon")
	val uicon: Uicon?,

	@field:SerializedName("Remember me")
	val rememberMe: RememberMe?,

	@field:SerializedName("Water Filtration")
	val waterFiltration: WaterFiltration?,

	@field:SerializedName("black white")
	val blackWhite: BlackWhite?,

	@field:SerializedName("Best Dad")
	val bestDad: BestDad?,

	@field:SerializedName("Emoji")
	val emoji: Emoji?,

	@field:SerializedName("Congratulations Graduates")
	val congratulationsGraduates: CongratulationsGraduates?,

	@field:SerializedName("snow world")
	val snowWorld: SnowWorld?,

	@field:SerializedName("vintage paper texture")
	val vintagePaperTexture: VintagePaperTexture?,

	@field:SerializedName("graduation season")
	val graduationSeason: GraduationSeason?,

	@field:SerializedName("the whole")
	val theWhole: TheWhole?,

	@field:SerializedName("baby boom")
	val babyBoom: BabyBoom?,

	@field:SerializedName("hug and kiss")
	val hugAndKiss: HugAndKiss?,

	@field:SerializedName("Crumpled Kraft Paper")
	val crumpledKraftPaper: CrumpledKraftPaper?,

	@field:SerializedName("happy teachers day")
	val happyTeachersDay: HappyTeachersDay?,

	@field:SerializedName("Happy Autumn")
	val happyAutumn: HappyAutumn?,

	@field:SerializedName("All About the love")
	val allAboutTheLove: AllAboutTheLove?,

	@field:SerializedName("Cloud")
	val cloud: Cloud?,

	@field:SerializedName("Dia Dos Namorados")
	val diaDosNamorados: DiaDosNamorados?,

	@field:SerializedName("Paper")
	val paper: Paper?,

	@field:SerializedName("japanese Pattern")
	val japanesePattern: JapanesePattern?,

	@field:SerializedName("Back to School")
	val backToSchool: BackToSchool?,

	@field:SerializedName("pumpkin")
	val pumpkin: Pumpkin?
)

data class VintagePaper(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyDiwali(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class DiaDeMuertos(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class DiaDosNamorados(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ValentineDay(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BestDad(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class bgLove(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class FallingInLove(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Holographic(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class SnowWorld(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ILoveYou(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Worldwide(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HelloFall(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class LoveTerims(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Cloud(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class WrapItUp(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HugAndKiss(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class WinterWonderland(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class CongratulationsGraduates(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Marble(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Halloween(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Floral(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class EmojiBanner(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Woldlife(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class FairTradeFruits(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Watercolor(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class TheWhole(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class SweetLittleFamily(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class MerryChristmas(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyBirthday(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class WelcomeBackToSchool(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class FlowerVintage(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class TrickOrTreat(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HelloSpring(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class MemphisEvent(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BestDayEver(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class GoldDust(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyHoli(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Tropical(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyChildrensDay(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyThanksgiving(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyGraduation(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class bgChristmas(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Uicon(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class SummerTime(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ChildlikeGraffiti(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BackToSchool(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class NoteAndPaper(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class BohemianPatterns(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyAutumn(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Autumnn(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Pattern(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class PinkWedding(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ARTISTIC(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class PoolParty(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyLabourDay(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Emoji(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Botanical(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class Space(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class ILoveYouMom(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class XOXO(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class HappyTeachersDay(
	@field:SerializedName("Group")
	val group: bgGroup?
)

data class EidAlAdha(
	@field:SerializedName("Group")
	val group: bgGroup?
)
