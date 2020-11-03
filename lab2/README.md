<h1>GET /stringAnalyse</h1>
Returns JSON object with information about how many uppercase letters, lowercase letters, numbers and special characters given String contains.

<h2>Parameters</h2>
<table>
<tr>
<th>Name</th>
<th>Required?</th>
<th>Description</th>
</tr>
<tr>
<td>string</td>
<td>yes</td>
<td>String which will be analysed</td>
</tr>
<table>

<h2>Example request</h2>

<code>GET localhost:8080/stringAnalyse?string="AAAbbb123!@#"</code>

<h2>Example response</h2>
<code>
{
"uppercaseLettersCount" : 3,
"lowercaseLettersCount" : 3,
"numbersCount" : 3,
"specialCharactersCount" : 3
}
</code>

