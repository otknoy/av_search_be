riot.tag2('items', '<div each="{item in items}"> <img riot-src="{item.imageUrl}"> <p>{item.title}</p> <div each="{actress in item.actress}"> <p> <a href="?query={actress}">{actress}</a> </p> </div> <div each="{genre in item.genre}"> <p> <a href="?query={genre}">{genre}</a> </p> </div> </div>', 'items,[data-is="items"]{ backgroud: #fff000; }', '', function(opts) {
   this.items = opts.items;
});
