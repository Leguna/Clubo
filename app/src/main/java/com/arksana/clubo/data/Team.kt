package com.arksana.clubo.data

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("teams")
    val teams: List<Team?>?
)

data class Team(
    @SerializedName("idLeague")
    val idLeague: String?, // 4328
    @SerializedName("idSoccerXML")
    val idSoccerXML: String?, // 9
    @SerializedName("idTeam")
    val idTeam: String?, // 133604
    @SerializedName("intFormedYear")
    val intFormedYear: String?, // 1892
    @SerializedName("intLoved")
    val intLoved: String?, // 2
    @SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String?, // 60338
    @SerializedName("strAlternate")
    val strAlternate: String?, // Gunners
    @SerializedName("strCountry")
    val strCountry: String?, // England
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: Any?, // null
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String?, // Der FC Arsenal (offiziell: Arsenal Football Club) – auch bekannt als (The) Arsenal, (The) Gunners (deutsche Übersetzung: „Schützen“ oder „Kanoniere“) oder im deutschen Sprachraum auch Arsenal London genannt – ist ein 1886 gegründeter Fußballverein aus dem Ortsteil Holloway des Nordlondoner Bezirks Islington. Mit 13 englischen Meisterschaften und elf FA-Pokalsiegen zählt der Klub zu den erfolgreichsten englischen Fußballvereinen.Erst über 40 Jahre nach der Gründung gewann Arsenal mit fünf Ligatiteln und zwei FA Cups in den 1930er Jahren seine ersten bedeutenden Titel. Der nächste Meilenstein war in der Saison 1970/71 der Gewinn des zweiten englischen „Doubles“ im 20. Jahrhundert. In den vergangenen 20 Jahren etablierte sich Arsenal endgültig als einer der erfolgreichsten englischen Fußballvereine, und beim Gewinn zweier weiterer Doubles zu Beginn des 21. Jahrhunderts blieb die Mannschaft in der Ligasaison 2003/04 als zweite in der englischen Fußballgeschichte ungeschlagen. Zunehmende europäische Ambitionen unterstrich der Verein in der Spielzeit 2005/06, als Arsenal als erster Londoner Verein das Finale der Champions League erreichte.
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?, // Arsenal Football Club is a professional football club based in Holloway, London which currently plays in the Premier League, the highest level of English football. One of the most successful clubs in English football, they have won 13 First Division and Premier League titles and a joint record 11 FA Cups.Arsenal's success has been particularly consistent: the club has accumulated the second most points in English top-flight football, hold the ongoing record for the longest uninterrupted period in the top flight, and would be placed first in an aggregated league of the entire 20th century. Arsenal is the second side to complete an English top-flight season unbeaten (in the 2003–04 season), playing almost twice as many matches as the previous invincibles Preston North End in the 1888–89 season.Arsenal was founded in 1886 in Woolwich and in 1893 became the first club from the south of England to join the Football League. In 1913, they moved north across the city to Arsenal Stadium in Highbury. In the 1930s, they won five League Championship titles and two FA Cups. After a lean period in the post-war years they won the League and FA Cup Double, in the 1970–71 season, and in the 1990s and first decade of the 21st century, won two more Doubles and reached the 2006 UEFA Champions League Final. Since neighbouring Tottenham Hotspur, the two clubs have had a fierce rivalry, the North London derby.Arsenal have one of the highest incomes and largest fanbases in the world. The club was named the fifth most valuable association football club in the world, valued at £1.3 billion in 2014.
    @SerializedName("strDescriptionES")
    val strDescriptionES: Any?, // null
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: Any?, // null
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: Any?, // null
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: Any?, // null
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String?, // L'Arsenal Football Club, noto semplicemente come Arsenal, è una società calcistica inglese con sede a Londra, più precisamente nel quartiere di Holloway, nel borgo di Islington.[3]Fondato nel 1886, è uno dei quattordici club che rappresentano la città di Londra a livello professionistico,[4] nonché uno dei più antichi del Paese. Milita nella massima serie del calcio inglese ininterrottamente dal 1919-1920, risultando quindi la squadra da più tempo presente in First Division/Premier League. È la prima squadra della capitale del Regno Unito per successi sportivi e, in ambito federale, la terza dopo Manchester United e Liverpool, essendosi aggiudicata nel corso della sua storia tredici campionati inglesi, dodici FA Cup (record di vittorie, condiviso con il Manchester United), due League Cup e quattordici Community Shield (una condivisa),[5] mentre in ambito internazionale ha conquistato una Coppa delle Coppe ed una Coppa delle Fiere. Inoltre è una delle tredici squadre che hanno raggiunto le finali di tutte le tre principali competizioni gestite dalla UEFA: Champions League (2005-2006), Coppa UEFA (1999-2000) e Coppa delle Coppe (1979-1980, 1993-1994 e 1994-1995).[6]I colori sociali, rosso per la maglietta e bianco per i pantaloncini, hanno subìto variazioni più o meno evidenti nel corso degli anni. Anche la sede del club è stata cambiata più volte: inizialmente la squadra giocava a Woolwich, ma nel 1913 si spostò all'Arsenal Stadium, nel quartiere di Highbury; dal 2006 disputa invece le sue partite casalinghe nel nuovo Emirates Stadium. Lo stemma è stato modificato ripetutamente, ma al suo interno è sempre comparso almeno un cannone. Proprio per questo motivo i giocatori ed i tifosi dell'Arsenal sono spesso soprannominati Gunners (in italiano "cannonieri").L'Arsenal conta su una schiera di tifosi molto nutrita, distribuita in ogni parte del mondo. Nel corso degli anni sono sorte profonde rivalità con i sostenitori di club concittadini, la più sentita delle quali è quella con i seguaci del Tottenham Hotspur, con i quali i Gunners giocano regolarmente il North London derby.[7] L'Arsenal è anche uno dei club più ricchi del mondo, con un patrimonio stimato di 1,3 miliardi di dollari, secondo la rivista Forbes nel 2014, facendone il quinto club più ricco del pianeta e il secondo in Inghilterra.[8]
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: Any?, // null
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: Any?, // null
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: Any?, // null
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: Any?, // null
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: Any?, // null
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: Any?, // null
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: Any?, // null
    @SerializedName("strDivision")
    val strDivision: Any?, // null
    @SerializedName("strFacebook")
    val strFacebook: String?, // www.facebook.com/Arsenal
    @SerializedName("strGender")
    val strGender: String?, // Male
    @SerializedName("strInstagram")
    val strInstagram: String?, // instagram.com/arsenal
    @SerializedName("strKeywords")
    val strKeywords: String?, // Gunners, Gooners
    @SerializedName("strLeague")
    val strLeague: String?, // English Premier League
    @SerializedName("strLocked")
    val strLocked: String?, // unlocked
    @SerializedName("strManager")
    val strManager: String?,
    @SerializedName("strRSS")
    val strRSS: String?, // https://www.allarsenal.com/feed/
    @SerializedName("strSport")
    val strSport: String?, // Soccer
    @SerializedName("strStadium")
    val strStadium: String?, // Emirates Stadium
    @SerializedName("strStadiumDescription")
    val strStadiumDescription: String?, // The Emirates Stadium (known as Ashburton Grove prior to sponsorship) is a football stadium in Holloway, London, England, and the home of Arsenal Football Club. With a capacity of 60,272, the Emirates is the third-largest football stadium in England after Wembley and Old Trafford.In 1997, Arsenal explored the possibility of relocating to a new stadium, having been denied planning permission by Islington Council to expand its home ground of Highbury. After considering various options (including purchasing Wembley), the club bought an industrial and waste disposal estate in Ashburton Grove in 2000. A year later they won the council's approval to build a stadium on the site; manager Arsène Wenger described this as the "biggest decision in Arsenal's history" since the board appointed Herbert Chapman. Relocation began in 2002, but financial difficulties delayed work until February 2004. Emirates Airline was later announced as the main sponsor for the stadium. Work was completed in 2006 at a cost of £390 million.
    @SerializedName("strStadiumLocation")
    val strStadiumLocation: String?, // Holloway, London
    @SerializedName("strStadiumThumb")
    val strStadiumThumb: String?, // https://www.thesportsdb.com/images/media/team/stadium/qpuxrr1419371354.jpg
    @SerializedName("strTeam")
    val strTeam: String?, // Arsenal
    @SerializedName("strTeamBadge")
    val strTeamBadge: String?, // https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png
    @SerializedName("strTeamBanner")
    val strTeamBanner: String?, // https://www.thesportsdb.com/images/media/team/banner/rtpsrr1419351049.jpg
    @SerializedName("strTeamFanart1")
    val strTeamFanart1: String?, // https://www.thesportsdb.com/images/media/team/fanart/xyusxr1419347566.jpg
    @SerializedName("strTeamFanart2")
    val strTeamFanart2: String?, // https://www.thesportsdb.com/images/media/team/fanart/qttspr1419347612.jpg
    @SerializedName("strTeamFanart3")
    val strTeamFanart3: String?, // https://www.thesportsdb.com/images/media/team/fanart/uwssqx1420884450.jpg
    @SerializedName("strTeamFanart4")
    val strTeamFanart4: String?, // https://www.thesportsdb.com/images/media/team/fanart/qtprsw1420884964.jpg
    @SerializedName("strTeamJersey")
    val strTeamJersey: String?, // https://www.thesportsdb.com/images/media/team/jersey/2019-133604-Jersey.png
    @SerializedName("strTeamLogo")
    val strTeamLogo: String?, // https://www.thesportsdb.com/images/media/team/logo/q2mxlz1512644512.png
    @SerializedName("strTeamShort")
    val strTeamShort: String?, // Ars
    @SerializedName("strTwitter")
    val strTwitter: String?, // twitter.com/arsenal
    @SerializedName("strWebsite")
    val strWebsite: String?, // www.arsenal.com
    @SerializedName("strYoutube")
    val strYoutube: String? // www.youtube.com/user/ArsenalTour
)