<h1>GET /weeiaCalendar</h1>
Returns ICS calendar file for: <a href="http://www.weeia.p.lodz.pl/">http://www.weeia.p.lodz.pl/</a>. 

<h2>Parameters</h2>
<table>
<tr>
<th>Name</th>
<th>Required?</th>
<th>Description</th>
</tr>
<tr>
<td>month</td>
<td>no</td>
<td>Number representing the month for which calendar should be downloaded. If parameter is
not provided current month will be used. If number less than 10 is provided it should be followed by 0</td>
</tr>
</table>

<h2>Example request</h2>

<code>GET localhost:8080/weeiaCalendar?month=02</code>

<h2>Example response</h2>


