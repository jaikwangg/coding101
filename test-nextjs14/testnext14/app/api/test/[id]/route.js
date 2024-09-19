export async function GET(request,{params}) {
    console.log('test')
    return Response.json({
        name:'jaikwang',
        id:params.id
    })
}