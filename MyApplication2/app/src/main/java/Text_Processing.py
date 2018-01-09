def text(z):
    pp=z.lower()
    noun=["fan","light","lights","fans"]
    verb=["on","off"]
    compound=["and","but"]
    token=pp.split(",")
    noune=list(set(token)& set(noun))
    verbo=list(set(token)& set(verb))
    compounde=list(set(token)& set(compound))
    x=len(noune)
    y=len(verbo)
    a=len(compound)
    g=verbo[0]
    u=0
    light=3
    fan=3
    for g in g:
        u=u+ord(g)
    if(a>0 and y>1):
        b=pp.index("on")
        c=pp.index("off")
        d=pp.index("light"or "lights")
        e=pp.index("fan"or "fans")
        g=abs(d-c)
        h=abs(d-b)
        if(g>h):
            light=1
            fan=0
        else:
            light=0
            fan=1
    if(x==2 and y==1):
        if u==315:
            light=0
            fan=0
        else:
            light=1
            fan=1
    if((("light" or "lights")in noune) and (u==315)):
        light=0
    elif((("light" or "lights")in noune) and (u!=315)):
        light=1
    if((("fan" or "fans")in noune)and (u==315)):
        fan=0
    elif((("fans" or "fan") in noune) and (u!=315)):
        fan=1
    print ("Yeah")