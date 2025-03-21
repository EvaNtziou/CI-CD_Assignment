<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Resource</title>
</head>
<body>
    <h1>Edit Resource</h1>
    <form action="/api/resources/${resource.id}/edit" method="POST">
        <label for="name">Resource Name:</label>
        <input type="text" id="name" name="name" value="${resource.name}" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${resource.quantity}" required><br>
        <button type="submit">Update Resource</button>
    </form>
    <br>
    <a href="/api/resources/view">Back to Resources</a>
</body>
</html>
