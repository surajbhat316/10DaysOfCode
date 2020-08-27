#include<bits/stdc++.h>
#define ll long long int
#define MOD 1000000007
using namespace std;
ll modmulinverse(ll a,ll m)
{
    ll x = 0,y = 1,u = 1,v = 0;
    ll e = m,f = a;
    ll c,d,q,r;
    while(f != 1)
    {
        q = e/f;
        r = e%f;
        c = x-q*u;
        d = y-q*v;
        x = u;
        y = v;
        u = c;
        v = d;
        e = f;
        f = r;
    }
    u = (u+m)%m;
    return u;
}
ll mod(ll a,ll b,ll n){
    ll res=1;

      while (b)
{
    if (b % 2) { res = (res * a) % n; }

    a = (a * a) % n;
    b /= 2;
}

return res;
}

int main()
{
    ll t;
    cin>>t;
    while(t--){
            ll a,b,x,ans;
    cin>>a>>b>>x;
    a=a%x;
    if (b<0) a=modmulinverse(a,x);
    ans=mod(a,b,x);
    cout<<ans<<endl;

    }
    return 0;
}
