<items>
  <div each={item in items}>
    <img src="{item.imageUrl}">
    <p>{item.title}</p>
    <div each="{actress in item.actress}">
      <p>
	<a href="?query={actress}">{actress}</a>
      </p>
    </div>

    <div each="{genre in item.genre}">
      <p>
	<a href="?query={genre}">{genre}</a>
      </p>
    </div>
  </div>

  <style>
   :scope {
     backgroud: #fff000;
   }
  </style>

  <script>
   this.items = opts.items;
  </script>
</items>
