<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        ${title}
    </div>

    <div class="container">
        <h1>Single1 Form</h1>
        <form action="/upload/single1" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="file1" class="form-label">File1</label>
                <input type="file" class="form-control" id="file1" name="file1">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>

    <div class="container">
        <h1>Single2 Form</h1>
        <form action="/upload/single2" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="file1" class="form-label">File1</label>
                <input type="file" class="form-control" id="file1" name="file1">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>

    <div class="container">
        <h1>Multiple Form</h1>
        <form action="/upload/multiple1" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="file1" class="form-label">File1</label>
                <input type="file" class="form-control" id="file1" name="file1" multiple>
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>

    <div class="container">
        <h1>Multi Form</h1>
        <form action="/upload/multiple2" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="file1" class="form-label">File1</label>
                <input type="file" class="form-control" id="file1" name="file1">
            </div>
            <div class="mb-3">
                <label for="file2" class="form-label">File2</label>
                <input type="file" class="form-control" id="file2" name="file2">
            </div>
            <div class="mb-3">
                <label for="file3" class="form-label">File3</label>
                <input type="file" class="form-control" id="file3" name="file3">
            </div>
            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>








<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>