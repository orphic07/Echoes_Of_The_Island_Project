<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Echoes of the Island</title>
    <style>
        body {
            background: radial-gradient(circle at center, #d8cfb4 0%, #a79874 100%);
            font-family: 'Georgia', serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .page {
            background: #f5eedc;
            border: 1px solid #b8a97a;
            box-shadow: 0 0 40px rgba(0, 0, 0, 0.3);
            padding: 2.5rem 3.5rem;
            width: 700px;
            max-width: 90%;
            line-height: 1.8;
            border-radius: 8px;
            color: #2c1d09;
            position: relative;
        }

        .page::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: radial-gradient(ellipse at center, rgba(0,0,0,0) 70%, rgba(0,0,0,0.25) 100%);
            border-radius: 8px;
            pointer-events: none;
        }

        h1 {
            text-align: center;
            font-family: 'Times New Roman', serif;
            letter-spacing: 1.5px;
            color: #3b2a14;
            margin-bottom: 1.5rem;
        }

        p {
            text-indent: 30px;
        }

        .start-link {
            display: block;
            margin-top: 2rem;
            text-align: center;
            font-weight: bold;
            color: #3b2a14;
            text-decoration: underline;
            font-style: italic;
            transition: all 0.3s ease;
        }

        .start-link:hover {
            color: #6b4a2b;
            letter-spacing: 1px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="page">
    <h1>Echoes of the Island</h1>

    <p>
        The last thing I remember is the storm swallowing our boat whole. The ocean twisted,
        the sky tore open—and then, <strong>silence</strong>.
    </p>

    <p>
        When we woke up, Sam was beside me. The sand was dark as ash, and the air heavy
        with something I can’t explain. There’s no sun here, only a pale glow behind the clouds.
        The trees move as if they’re <strong>breathing</strong>.
    </p>

    <p>
        We don’t know where we are, but <strong>we’re alive</strong>. And whatever we saw in that storm...
        it’s somewhere on this <strong>island</strong>.
    </p>

    <a href="game" class="start-link">
        _And so it begins..._
    </a>
</div>
</body>
</html>

