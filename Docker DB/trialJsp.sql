PGDMP     (    #                z            trialJsp    14.0    14.0                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    25583    trialJsp    DATABASE     l   CREATE DATABASE "trialJsp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Arabic_Saudi Arabia.1256';
    DROP DATABASE "trialJsp";
                postgres    false            ?            1259    25627    cart    TABLE     _   CREATE TABLE public.cart (
    productid integer,
    userid integer,
    quantity smallint
);
    DROP TABLE public.cart;
       public         heap    postgres    false            ?            1259    25609    product    TABLE     ?   CREATE TABLE public.product (
    id integer NOT NULL,
    title character varying(100),
    price smallint,
    quantity smallint,
    photo character varying,
    details character varying,
    category character varying
);
    DROP TABLE public.product;
       public         heap    postgres    false            ?            1259    25608    product_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.product_id_seq;
       public          postgres    false    210                       0    0    product_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;
          public          postgres    false    209            ?            1259    25618    users    TABLE     ?  CREATE TABLE public.users (
    id integer NOT NULL,
    admin boolean,
    name character varying(15),
    birthday date,
    password character varying,
    phonenumber integer,
    job character varying,
    email character varying,
    creditlimit integer,
    address character varying,
    interests character varying,
    CONSTRAINT users_creditlimit_check CHECK (((creditlimit < 500) AND (creditlimit > 0)))
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    25617    users_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    212                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    211            e           2604    25612 
   product id    DEFAULT     h   ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);
 9   ALTER TABLE public.product ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            f           2604    25621    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211    212            ?          0    25627    cart 
   TABLE DATA           ;   COPY public.cart (productid, userid, quantity) FROM stdin;
    public          postgres    false    213   ?       ?          0    25609    product 
   TABLE DATA           W   COPY public.product (id, title, price, quantity, photo, details, category) FROM stdin;
    public          postgres    false    210   ?       ?          0    25618    users 
   TABLE DATA           ~   COPY public.users (id, admin, name, birthday, password, phonenumber, job, email, creditlimit, address, interests) FROM stdin;
    public          postgres    false    212   ?                  0    0    product_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.product_id_seq', 3, true);
          public          postgres    false    209                       0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 5, true);
          public          postgres    false    211            i           2606    25616    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    210            k           2606    25626    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    212            l           2606    25630    cart cart_productid_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(id);
 B   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_productid_fkey;
       public          postgres    false    3177    213    210            m           2606    25635    cart cart_userid_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_userid_fkey FOREIGN KEY (userid) REFERENCES public.users(id);
 ?   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_userid_fkey;
       public          postgres    false    212    213    3179            ?      x?????? ? ?      ?   ?   x?%?K? ?p
/ -?g1g???t?	?`??:?m*?Rȗ?{-??|??> ca?"??$?8Z-'?d6?Z??u?Sh?dk????w?jnTCvJj??e??Z?I?'~?D4??E?{?,vbc??!"?
???7      ?   ?   x???M
?0FדSx???I?t?A?ۢi!??1REDf1?7?1?!?IO@}???A?#z?y?fռ?!??????He?e???އ??\IR?!{g??????./?6?'???%????.0?E???%?????[??n?_rh?17X?f     