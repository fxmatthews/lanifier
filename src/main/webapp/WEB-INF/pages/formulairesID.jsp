<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Récupération des IDs</title>
<SCRIPT language="javascript">
<!--
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount + 1;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		var length = (table.rows.length) - 1;
		element2.name = "ids[" + length + "]";
		cell3.appendChild(element2);

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}
</SCRIPT>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Récupération des ID</h1>
	<form:form commandName="steamIDList" method="post">

		<fieldset>
			<legend>ID steam des joueurs</legend>
			<ol>
				<li><INPUT type="button" value="Ajouter un ID"
					onclick="addRow('dataTable')" /> <INPUT type="button"
					value="Supprimer les ID sélectionnés"
					onclick="deleteRow('dataTable')" />
					<TABLE id="dataTable" width="350px" border="1">
						<TR>
							<TD><INPUT type="checkbox" name="chk" /></TD>
							<TD>1</TD>
							<TD><INPUT type='text' name="ids[0]" /></TD>
						</TR>
					</TABLE></li>

			</ol>
		</fieldset>
		<fieldset>
			<button type=submit>Trouvez nous des jeux !</button>
		</fieldset>
	</form:form>

</body>
</html>

