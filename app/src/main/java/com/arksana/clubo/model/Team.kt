package com.arksana.clubo.model

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("teams")
    val teams: List<Team> = listOf()
)

data class Team(
    @SerializedName("idTeam")
    val idTeam: String = "", // 135152
    @SerializedName("idSoccerXML")
    val idSoccerXML: String = "", // 1345
    @SerializedName("intLoved")
    val intLoved: String = "", // 2
    @SerializedName("strTeam")
    val strTeam: String = "", // Arsenal Sarandi
    @SerializedName("strTeamShort")
    val strTeamShort: String = "", // Ars
    @SerializedName("strAlternate")
    val strAlternate: String = "",
    @SerializedName("intFormedYear")
    val intFormedYear: String = "", // 1957
    @SerializedName("strSport")
    val strSport: String = "", // Soccer
    @SerializedName("strLeague")
    val strLeague: String = "", // _No League
    @SerializedName("idLeague")
    val idLeague: String = "", // 4367
    @SerializedName("strManager")
    val strManager: String = "", // Martín Palermo
    @SerializedName("strStadium")
    val strStadium: String = "", // Estadio Julio H. Grondona
    @SerializedName("strKeywords")
    val strKeywords: String = "",
    @SerializedName("strRSS")
    val strRSS: String = "",
    @SerializedName("strStadiumThumb")
    val strStadiumThumb: String = "", // https://www.thesportsdb.com/images/media/team/stadium/qpuxrr1419371354.jpg
    @SerializedName("strStadiumDescription")
    val strStadiumDescription: String = "", // Estadio Julio H. Grondona, or the Estadio Viaducto, is a multi-use stadium in Buenos Aires, Argentina. It is currently used primarily for football matches and is the home stadium of Arsenal de Sarandí.The stadium holds 18,300 people. Estadio Julio H. Grondona is famous for its "chinchulines" (chitterlings), a popular Argentinian food sold by many vendors.
    @SerializedName("strStadiumLocation")
    val strStadiumLocation: String = "", // Sarandí, Avellaneda Partido
    @SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String = "", // 18300
    @SerializedName("strWebsite")
    val strWebsite: String = "",
    @SerializedName("strFacebook")
    val strFacebook: String = "",
    @SerializedName("strTwitter")
    val strTwitter: String = "",
    @SerializedName("strInstagram")
    val strInstagram: String = "",
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String = "", // Arsenal Fútbol Club (Spanish pronunciation: ), usually referred as Arsenal de Sarandí , is an Argentine sports club from the Sarandí district of Avellaneda Partido, Greater Buenos Aires.The football team currently plays in Primera División, the top division of the Argentine football league system. The squad plays its home games at the Estadio Julio H. Grondona, named after one of the founders, which has a capacity of 16,000. It opened in 1964 but was not used in the First Division until 2004. The club's colours are red and light blue, in honour of the traditional teams of Avellaneda (Independiente and Racing). Arsenal won its first Primera División championship in 2012. Until then, club's major title had been the Copa Sudamericana won in 2007.Apart from football, the club hosts other sports such as handball and field hockey.The club was founded in January 1957 by brothers Héctor and Julio Humberto Grondona. The club were founded near to where the country's military arsenal was housed, which inspired the name. The team's shirt colour is light blue with a diagonal red band (similar to the shirt used by River Plate). The colours were chosen as a combination of the two older clubs in Avellaneda – Racing (light blue) and Independiente (red).The 1962 Arsenal team, which won the first official title for the institution.Julio Grondona went on to become president of Independiente, and then, in 1979, president of the Argentine Football Association, a post he still holds. He is also a vice-president of FIFA. Héctor Grondona, and then son Julio Ricardo, became presidents of Arsenal.The club's best known former player is Jorge Burruchaga, who started his career at Arsenal in 1979, and had several stints as coach. Burru, as he is nicknamed, scored the winning goal for Argentina in the 1986 FIFA World Cup final against Germany.Arsenal's football team was promoted to successively higher divisions in 1962, 1986 and 1992, finally reaching the Primera División in 2002.On 6 September 2006, Arsenal and Spanish club FC Barcelona (Barça) struck a deal whereby in exchange for the option to acquire young players that have not played more than one year in the Arsenal first team, Barça would help to improve Arsenal's infrastructure.A member from Barça was to oversee the project, and visit the club on a monthly basis. This deal, however, fell through in 2007, reportedly because Arsenal could not afford the infrastructure to keep up with the plan.
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String = "", // Der FC Arsenal (offiziell: Arsenal Football Club) – auch bekannt als (The) Arsenal, (The) Gunners (deutsche Übersetzung: „Schützen“ oder „Kanoniere“) oder im deutschen Sprachraum auch Arsenal London genannt – ist ein 1886 gegründeter Fußballverein aus dem Ortsteil Holloway des Nordlondoner Bezirks Islington. Mit 13 englischen Meisterschaften und elf FA-Pokalsiegen zählt der Klub zu den erfolgreichsten englischen Fußballvereinen.Erst über 40 Jahre nach der Gründung gewann Arsenal mit fünf Ligatiteln und zwei FA Cups in den 1930er Jahren seine ersten bedeutenden Titel. Der nächste Meilenstein war in der Saison 1970/71 der Gewinn des zweiten englischen „Doubles“ im 20. Jahrhundert. In den vergangenen 20 Jahren etablierte sich Arsenal endgültig als einer der erfolgreichsten englischen Fußballvereine, und beim Gewinn zweier weiterer Doubles zu Beginn des 21. Jahrhunderts blieb die Mannschaft in der Ligasaison 2003/04 als zweite in der englischen Fußballgeschichte ungeschlagen. Zunehmende europäische Ambitionen unterstrich der Verein in der Spielzeit 2005/06, als Arsenal als erster Londoner Verein das Finale der Champions League erreichte.
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String = "", // L'Arsenal Football Club, noto semplicemente come Arsenal, è una società calcistica inglese con sede a Londra, più precisamente nel quartiere di Holloway, nel borgo di Islington.[3]Fondato nel 1886, è uno dei quattordici club che rappresentano la città di Londra a livello professionistico,[4] nonché uno dei più antichi del Paese. Milita nella massima serie del calcio inglese ininterrottamente dal 1919-1920, risultando quindi la squadra da più tempo presente in First Division/Premier League. È la prima squadra della capitale del Regno Unito per successi sportivi e, in ambito federale, la terza dopo Manchester United e Liverpool, essendosi aggiudicata nel corso della sua storia tredici campionati inglesi, dodici FA Cup (record di vittorie, condiviso con il Manchester United), due League Cup e quattordici Community Shield (una condivisa),[5] mentre in ambito internazionale ha conquistato una Coppa delle Coppe ed una Coppa delle Fiere. Inoltre è una delle tredici squadre che hanno raggiunto le finali di tutte le tre principali competizioni gestite dalla UEFA: Champions League (2005-2006), Coppa UEFA (1999-2000) e Coppa delle Coppe (1979-1980, 1993-1994 e 1994-1995).[6]I colori sociali, rosso per la maglietta e bianco per i pantaloncini, hanno subìto variazioni più o meno evidenti nel corso degli anni. Anche la sede del club è stata cambiata più volte: inizialmente la squadra giocava a Woolwich, ma nel 1913 si spostò all'Arsenal Stadium, nel quartiere di Highbury; dal 2006 disputa invece le sue partite casalinghe nel nuovo Emirates Stadium. Lo stemma è stato modificato ripetutamente, ma al suo interno è sempre comparso almeno un cannone. Proprio per questo motivo i giocatori ed i tifosi dell'Arsenal sono spesso soprannominati Gunners (in italiano "cannonieri").L'Arsenal conta su una schiera di tifosi molto nutrita, distribuita in ogni parte del mondo. Nel corso degli anni sono sorte profonde rivalità con i sostenitori di club concittadini, la più sentita delle quali è quella con i seguaci del Tottenham Hotspur, con i quali i Gunners giocano regolarmente il North London derby.[7] L'Arsenal è anche uno dei club più ricchi del mondo, con un patrimonio stimato di 1,3 miliardi di dollari, secondo la rivista Forbes nel 2014, facendone il quinto club più ricco del pianeta e il secondo in Inghilterra.[8]
    @SerializedName("strGender")
    val strGender: String = "", // Male
    @SerializedName("strCountry")
    val strCountry: String = "", // Argentina
    @SerializedName("strTeamBadge")
    val strTeamBadge: String = "", // https://www.thesportsdb.com/images/media/team/badge/uy9k821517767802.png
    @SerializedName("strTeamJersey")
    val strTeamJersey: String = "", // https://www.thesportsdb.com/images/media/team/jersey/wwqpqw1423783752.png
    @SerializedName("strTeamLogo")
    val strTeamLogo: String = "", // https://www.thesportsdb.com/images/media/team/logo/q2mxlz1512644512.png
    @SerializedName("strTeamFanart1")
    val strTeamFanart1: String = "", // https://www.thesportsdb.com/images/media/team/fanart/xyusxr1419347566.jpg
    @SerializedName("strTeamFanart2")
    val strTeamFanart2: String = "", // https://www.thesportsdb.com/images/media/team/fanart/qttspr1419347612.jpg
    @SerializedName("strTeamFanart3")
    val strTeamFanart3: String = "", // https://www.thesportsdb.com/images/media/team/fanart/uwssqx1420884450.jpg
    @SerializedName("strTeamFanart4")
    val strTeamFanart4: String = "", // https://www.thesportsdb.com/images/media/team/fanart/qtprsw1420884964.jpg
    @SerializedName("strTeamBanner")
    val strTeamBanner: String = "", // https://www.thesportsdb.com/images/media/team/banner/rtpsrr1419351049.jpg
    @SerializedName("strYoutube")
    val strYoutube: String = ""
)