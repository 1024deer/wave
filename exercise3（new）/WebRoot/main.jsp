<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.User" %>
<%@ page import="dao.UserDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script src="js/jquery-3.5.0.min.js"></script>
  </head>
  
  <body style="background-image: url(images/bg.png);">
   <div id="head">
   	<div id="logo">
   		<img src="images/logo.png"/>
   	</div>
   	<div>
   		<div id="userinfo">     
			<div id="islogin">
				<span>欢迎你： ${user.chrName} 
				</span><a href="servlet/LogoutController.do">【安全退出】</a>
			</div> 
			<div id="notlogin" style="display: none;">
				<a href="login.html" style="margin-left: 120px;">登&nbsp;录</a>
				<a href="register.html" style="margin-left: 20px;">注&nbsp;册</a>
			</div>
   		</div>
		
   		<div id="daohang">
			<ul>
				<li><a class="aaa"  href="user.jsp">个人中心</a></li>
				<li><a class="aaa"  href="downloadManage.jsp">资源管理</a></li>
				<li><a class="aaa"  href="userManage.jsp">用户管理</a></li>
				<li><a class="aaa" href="download.jsp">资源下载</a></li>
				<li><a class="aaa" href="main.jsp">首页</a></li>
			</ul>
   		</div>
   	</div>
   </div>
   </div>
   <div id="content">
   <h1 style="text-align: center;"> Is There Life on Venus? These Missions Could Find It</h1>
   <p style=" text-align: center; color: gray;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Following a tantalizing discovery, these spacecraft could be headed to Earth’s twisted twin in search of the truth</p>
   	<div ><img align="center" src="images/1_source.jpg" style="margin: auto 15%;"/></div>
   	<div class="mura-region-local"><p>For decades, scientists have treated Venus as Earth&rsquo;s estranged sister gone bad.<strong> </strong>Once considered a promising planetary destination because of its near equivalence to our own world in size and mass, robotic scouts revealed Venus to be a pressure-cooked globe inimical to life&mdash;and to any further efforts to explore it. Now, however, hints of a possible Venusian biosphere are strengthening a surge of interest in our sister world.</p>
   	
   	<p>On September 14 an international team of researchers, led by Jane Greaves of Cardiff University in Wales, announced the detection of phosphine gas lingering in layers of the planet&rsquo;s atmosphere where temperatures and pressures are relatively balmy. Here on Earth, phosphine is only made industrially or by microbes that flourish in oxygen-free environments&mdash;meaning it could be a potential &ldquo;biosignature&rdquo; indicative of life. If confirmed, the finding would point to either of two possibilities: bizarre and wholly unexpected geochemistry on a lifeless Venus or the presence of some form of aerial alien biology in the planet&rsquo;s clement cloud decks.</p>
   	
   	<p>The bombshell announcement elicited excitement around the world, including from NASA administrator Jim Bridenstine. On Twitter, he called the discovery &ldquo;the most significant development yet in building the case for life off Earth&rdquo; and concluded with a recommendation to &ldquo;prioritize Venus&rdquo; in planning for future interplanetary missions.</p>
   	
   	<h2>Proposed Probes</h2>
   	
   	<p>The lively news from Venus&mdash;and Bridenstine&rsquo;s apparent endorsement of further exploration there&mdash;comes at an auspicious time. Under its Discovery Program, for instance, NASA is considering four space missions for launch later this decade, and two of them would be orbiters<strong> </strong>meant to scrutinize the cloud-shrouded rocky world.</p>
   	
   	<p>The DAVINCI+ (Deep Atmosphere Venus Investigation of Noble Gases, Chemistry, and Imaging Plus) mission consists of an orbiter that would, as part of its investigations, dispatch an instrumented probe to the Venusian atmosphere. Its competitor, the &ldquo;truth-seeking&rdquo; VERITAS (Venus Emissivity, Radio Science, InSAR, Topography, and Spectroscopy) orbiter, does not presently include an atmospheric probe. Instead the spacecraft would focus on radar scanning to help ascertain the planet&rsquo;s geologic history. NASA&rsquo;s announcement of its choice among these competing missions and two others is expected sometime next year.</p>
   	
   	<p>Beyond the current Discovery-class candidates, a newly completed Venus Flagship Mission study<strong> </strong>lays out a much more ambitious all-in-one venture that would send an orbiter, lander, two small satellites and a variable-altitude aerobot to scout our sister world. Such a mission, its proponents say, could set sail in June 2031, place its five science platforms at Venus in 2034 and culminate in a landing on the surface in May 2035.</p>
   	
   	<p>NASA is not the only space agency with Venus in its sights. The European Space Agency (ESA) is considering a planet-scanning radar probe of its own, dubbed EnVision, that could launch in 2032. In addition, Russia&rsquo;s proposed Venera-D mission could perhaps lift off as early as 2025. The mission was initially billed as a projected joint venture with the U.S. Roscosmos, Russia&rsquo;s space agency, now says that while it is not refusing to work with that country, it is avoiding &ldquo;wide international cooperation.&rdquo; This assertion reflects that Russia,<strong> </strong>more than any other spacefaring nation, has historically dominated the exploration of Venus&mdash;and seeks to preserve its preeminence there.</p>
   	
   	<p>&ldquo;We think that Venus is a Russian planet, so we shouldn&rsquo;t lag behind,&rdquo; Roscosmos chief Dmitry Rogozin recently said. Consequently, a comprehensive Russian-charted Venus research program consisting of several missions is reportedly in the works.</p>
   	
   	<h2>BepiColombo&rsquo;s Sneak Peek</h2>
   	
   	<p>Marking the calendar for nascent, yet to be funded space-agency missions to unravel Venus&rsquo;s lingering mysteries is, thankfully, not the only option available. There are other opportunities to grab up-close observations of the planet in the offing&mdash;including one coming next month.</p>
   	
   	<p>Launched in October 2018, ESA&rsquo;s BepiColombo spacecraft is headed for the planet Mercury. But to reach its target, the craft&rsquo;s trajectory includes two speed-boosting flybys of Venus, first in mid-October and then in August 2021. Some of BepiColombo&rsquo;s instruments that were designed to study Mercury can also be utilized to reconnoiter Venus&rsquo;s atmosphere, the mission&rsquo;s scientists say.</p>
   	
   	<p>&ldquo;While the first flyby is already planned, there is a possibility of configuring the second flyby to look for phosphine,&rdquo; says Darby Dyar of Mount Holyoke College, who chairs NASA&rsquo;s Venus Exploration Analysis Group.</p>
   	
   	<p>Even so, Dyar adds that to place the phosphine discovery in a planetary context, she and other researchers must know more about Venus&rsquo;s present-day habitability via measurements of atmospheric water vapor and &ldquo;hydrated&rdquo; minerals on the surface. &ldquo;Because water is the key to habitability, at least for life as we know it, following the water is what is really important here,&rdquo; she says.</p>
   	
   	<p>The reality is that the puzzle of Venusian phosphine will remain unsolved until several critical pieces of information are in hand, says Kandi Jessup, a senior research scientist at the Southwest Research Institute (SwRI). &ldquo;Definitive statements about biosignatures in Venus&rsquo;s atmosphere are dependent on how well we understand the chemistry occurring within the clouds, the rate of active volcanism at Venus, and any links that may exist between Venus&rsquo;s active volcanism and current cloud chemistry,&rdquo; she says. All of the proposals for new Venus missions are designed to advance some aspect of our necessarily broad understanding of the planet&rsquo;s environment. But none are likely to individually answer the critical question of whether our sister world actually harbors life.</p>
   	
   	<h2>Bringing Venus Down to Earth</h2>
   	
   	<p>If subsequent scouting of Venus&rsquo;s atmosphere reveals further indications of biosignatures and habitability, there is one possibility that could single-handedly deliver definitive proof of life: a sample return mission to gather potential organic material from plausibly habitable Venusian cloud layers and ferry it back to Earth. With a few caveats, that is the view of astrobiologist Dirk Schulze-Makuch, an adjunct professor at Washington State University.</p>
   	
   	<p>Schulze-Makuch says that for microbes to flourish in Venus&rsquo;s clouds, where sulfuric acid is abundant and water is scarce, they would have to be adapted to endure conditions beyond those encountered by Earth&rsquo;s microorganisms. &ldquo;But that doesn&rsquo;t mean they couldn&rsquo;t exist,&rdquo; he adds. Indeed, Schulze-Makuch maintains, finding further evidence of life on Venus could free astrobiologists from the &ldquo;arrogance&rdquo; of assuming that adaptations to extreme conditions exhibited by Earth life will always be the most optimal.</p>
   	
   	<p>&ldquo;On Earth, there are only a few localities with hyperacidity and none as extreme as on Venus, so there would not be much motivation for Earth life to evolve such adaptations,&rdquo; Schulze-Makuch says. &ldquo;On Venus, however, life might have had up to one billion years&rsquo; time to evolve such adaptations&rdquo; as <a href="https://www.scientificamerican.com/article/how-visiting-venus-will-help-us-find-life-on-distant-planets/">a runaway greenhouse effect</a> gradually pushed the once temperate world into its present hellish state.</p>
   	
   	<h2>The Private Sector Steps Up</h2>
   	
   	<p>In the meantime spotting a potential biosignature on Venus is spurring a private-sector response. For example, Breakthrough Initiatives, a privately funded space science effort, is <a href="https://www.scientificamerican.com/article/life-on-venus-breakthrough-initiatives-funds-study-of-possible-biosignature/">sponsoring a study</a> by top-tier specialists that will seek to clarify the parameters of primitive life dwelling within Venus&rsquo;s hostile skies.</p>
   	
   	<p>The group is led by Sara Seager, an astrophysicist at the Massachusetts Institute of Technology and a collaborator on the phosphine-discovery studies. Its charge is &ldquo;to push the envelope to try to understand what kind of life could exist in the very harsh Venus atmosphere and what further evidence for life a mission to Venus could search for,&rdquo; she says.<br />
   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
   	Then there is Rocket Lab, a private American aerospace manufacturer and launch service for small satellites that is slated to conduct its first deep-space mission next year: sending a NASA payload to the moon. That lunar foray will only be a prelude to an even more ambitious endeavor: a pint-sized Venusian atmospheric probe to seek additional evidence for or against potential life there. Riding on one of the company&rsquo;s Electron rockets onboard its small, proprietary Photon spacecraft, the mission could lift off as early as 2023.</p>
   	
   	<p>&ldquo;I'm completely fascinated by Venus,&rdquo; says Rocket Lab&rsquo;s founder and chief executive Peter Beck. &ldquo;There is so much we can learn about a planet that is so analogous to Earth. We understand life as it exists here on Earth, but life on Venus could be something really at odds with everything we know. If we can prove life exists off Earth, then it&rsquo;s fair to assume it could be prolific throughout the universe.&rdquo;</p>
   	
   	<p>Moreover, beyond the search for life, Beck says, Venus could offer another message. &ldquo;There&rsquo;s a huge amount we can unpack about climate change from studying Venus,&rdquo; he says. &ldquo;Venus was once possibly not to dissimilar to Earth, with oceans and water. Then it was enveloped in a shroud of carbon dioxide that drove a runaway greenhouse effect, pushing temperatures to extremes and turning the planet into the hellscape it is today. By taking a closer look at Venus, we might just be able to provide a glimpse into what could lay ahead for Earth in the case of runaway climate change.&rdquo;</p>
   	
   	<h2>Is It Life? Wait and See</h2>
   	
   	<p>The purported phosphine detection is indeed interesting, says Chris McKay, an astrobiologist at NASA&rsquo;s Ames Research Center. But he questions whether phosphine could actually be considered a biosignature.</p>
   	
   	<p>The claims of phosphine on Venus hinge on the interpretation of a single feature, a dip in a spectrum of the planet&rsquo;s atmosphere that was attributed to the gas&rsquo;s presence. Researchers saw the phosphine line in spectra gathered by two independent facilities: the James Clerk Maxwell Telescope on Mauna Kea in Hawaii and the Atacama Large Millimeter/submillimeter Array observatory in Chile. That dual detection is a boon for arguments that the finding is genuine, McKay says, but &ldquo;a robust detection would have several spectral features that are in relative agreement&rdquo; rather than just one.</p>
   	
   	<p>Advocates of airborne biology on Venus make a good case that there are no natural sources of phosphine on the planet, McKay adds. Then again, an equally compelling case can be made that because they are impoverished of water and enriched in sulfuric acid, the the so-called habitable cloud zones are, in fact, not<strong> </strong>at all suitable for life. &ldquo;So it would be premature to jump to any conclusion,&rdquo; he says. &ldquo;Basically, we<strong> </strong>have no coherent theory for how phosphine could be present on Venus.... Don&rsquo;t bet the farm on life just yet. It may not be phosphine. And if it is, it may not be biotic.&rdquo;</p>
   	
   	<p>Like McKay, another expert firmly in the &ldquo;wait and see&rdquo; contingent is Robert Grimm, a program director in planetary science at SwRI. He sketches out a checklist of what researchers should do next: &ldquo;Work out how good the observation is. Vet their claim that there can be no abiotic mechanisms. Look at the NASA queue and see what fits,&rdquo; Grimm says. &ldquo;If they exist, the bugs have been there for at least hundreds of millions of years. They can wait another decade.&rdquo;</p></div>
    	
    </div>

	<script>
		$(document).ready(function(){
			 var variable1 = "${user.chrName}";
			 if (variable1 == null || variable1 == undefined || variable1 == ''){
				 
				 document.getElementById("islogin").style.display="none";
				 document.getElementById("notlogin").style.display="block";
			 }
		})
		
	</script>
	
  </body>
</html>
