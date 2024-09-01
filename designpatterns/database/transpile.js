const fs = require('fs')

const files = [
  { raw: 'placa-mae-raw.json', result: 'placa-mae.json' },
  { raw: 'processador-raw.json', result: 'processador.json' },
  { raw: 'placa-de-video-raw.json', result: 'placa-de-video.json' },
  { raw: 'memoria-raw.json', result: 'memoria.json' },
  { raw: 'armazenamento-raw.json', result: 'armazenamento.json' },
  { raw: 'fonte-raw.json', result: 'fonte.json' },
  { raw: 'gabinete-raw.json', result: 'gabinete.json' },
]

function transpile({raw, result}) {
  const data = fs.readFileSync(`./raw/${raw}`);

  const newData = JSON.parse(data).products.map(product => ({
    id: product.id,
    name: product.title,
    description: product.description,
    price: Math.round(product.price * 100),
    image: product.photos.g[0]
  }))

  fs.writeFile(`./result/${result}`, JSON.stringify(newData, null, 2), (err) => console.log(err))
}

files.forEach(transpile)